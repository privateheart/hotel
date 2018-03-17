package io.renren.modules.workflow.service;

import io.renren.modules.workflow.dao.*;
import io.renren.modules.workflow.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by szj_pc on 2017/9/1.
 */

@Service("workFlowManager")
public class WorkFlowManager {
    @Autowired
    FlowTypeObjDao flowTypeObjDao;

    @Autowired
    FlowDao flowDao;

    @Autowired
    FlowNodeDao flowNodeDao;

    @Autowired
    FlowActionDao flowActionDao;

    @Autowired
    WfTaskDao wfTaskDao;

    @Autowired
    WorkFlowDao workFlowDao;

    @Autowired
    WfLogDao wfLogDao;

    @Autowired
    WfLogCorpDao wfLogCorpDao;

    @Autowired
    ObjTypeDao objTypeDao;

    @Autowired
    FlowRoleActionDao flowRoleActionDao;

    public Flow getFlowDefi(String objType) {
        List<FlowTypeObj> list = flowTypeObjDao.listFlowTypeObjByObjType(objType);
        if (list.size() > 0) {
            long tyid = ((FlowTypeObj) list.get(0)).getTypeID();
            List<Flow> fl = flowDao.listFlowByTypeId(tyid);
            if (fl.size() > 0)
                return (Flow) fl.get(0);
            return null;
        }
        return null;
    }

    public FlowNode findNodeById(long nodeid) {
        return flowNodeDao.getFlowNode(nodeid);
    }

    public FlowAction findActionById(Long id) {
        return flowActionDao.getFlowActionById(id);
    }

    public Long getWfIdByTaskId(long taskid) {
        WfTask wt = wfTaskDao.getWfTask(taskid);
        if (wt != null)
            return wt.getWfID();
        else
            return null;
    }

    //获取操作人员
//    public Object findOperById(String id) {
//        List l = this.workFlowCommDao
//                .findByNativeSQL("select e.username EMPID,e.nameCH NAMECH,'' ORGNAME,'' POSNAME from user e "
//                        + "where e.username = '"
//                        + id + "'");
//        if (l.size() > 0) {
//            Map opmap = (Map) l.get(0);
//            OperatorInfo oper = new OperatorInfo();
//            oper.setOperatorId((String) opmap.get("EMPID"));
//            oper.setOperatorName((String) opmap.get("NAMECH"));
//            oper.setOperatorOrg((String) opmap.get("ORGNAME"));
//            oper.setOperatorPos((String) opmap.get("POSNAME"));
//            return oper;
//        }
//        return null;
//    }

    public WfTask getWfTaskByWfID(long wfID){
        return wfTaskDao.getWfTask(wfID);
    }

    public WorkFlow findWorkFlowByTaskId(Long id) {
        WfTask wt = wfTaskDao.getWfTask(id);
        return workFlowDao.getWorkFlow(wt.getWfID());
    }

    public WfLog findLogById(Long id) {
        return wfLogDao.getWfLog(id);
    }

    public WorkFlow findWorkFlowById(Long id) {
        return workFlowDao.getWorkFlow(id);
    }

    public WfLogCorp findLogCorpById(Long id) {
        return wfLogCorpDao.getWfLogCorp(id);
    }

    public List<WorkFlow> findWFByObj(String objType, long objId) {
        List<WorkFlow> l = new ArrayList<WorkFlow>();
        l = workFlowDao.listWorkFlowByObjIdAndObjType(objId,objType);
        return l;
    }

    public List findOpenWFByObj(String objType, long objId) {
        List<WorkFlow> l = new ArrayList<WorkFlow>();
        l = this.workFlowDao.listwfidByObjIdAndObjType(objId,objType);
        return l;
    }

    public List findOpenCorTaskByLog(long wflogid) {
        List l = new ArrayList();
        l = this.workFlowDao.listwftaskidBywflogid(wflogid);
        return l;
    }

    public WfTask findMainTaskByLogId(Long id) {
        List<WfTask> list = wfTaskDao.listWfTaskBywfLogID(id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<WfLogCorp> findCorlogByLogId(long id) {
        List<WfLogCorp> list = wfLogCorpDao.listWfLogCorpBywfLogID(id);
        return list;
    }

    // 根据节点id取得最近的一个正向log,direction 0为进入节点 1为离开节点
    public WfLog findLastMainLogByNodeId(long nodeid, long wfid, int direction) {
        //String hql = "";
        List<WfLog> list = new ArrayList<>();
        if (direction == 0)
           list = workFlowDao.listLog(nodeid,wfid);
        if (direction == 1)
            list = workFlowDao.listLog(nodeid,wfid);
        if (list.size() > 0)
            return list.get(0);
        return null;
    }

    // 根据节点id取得最近的一个正向action,direction 0为进入节点 1为离开节点
    public FlowAction findLastMainActByNodeId(long nodeid, long wfid, int direction) {
        List<FlowAction> list = new ArrayList();
        if (direction == 0)
            list = workFlowDao.listAction(nodeid,wfid);
        if (direction == 1)
            list = workFlowDao.listAction(nodeid,wfid);
        //List<FlowAction> list = this.workFlowCommDao.find(hql);
        if (list.size() > 0)
            return list.get(0);
        return null;
    }

    public List<String> getCurrentRoleList(String ObjectType, long nodeid,
                                           String operatorId) {
        List<String> roles = new ArrayList<String>();
        ObjType obj = objTypeDao.getObjType(ObjectType);
        if (obj == null || obj.getSyscode() == null)
            return roles;
        FlowNode node = flowNodeDao.getFlowNode(nodeid);
        if (node == null)
            return roles;
        List<FlowRoleAction> l = flowRoleActionDao.listFlowRoleActionByNodeId(nodeid);
        Map<String, String> pMap = new HashMap<String, String>();
        pMap.put("empid", operatorId);
        pMap.put("catalog", obj.getSyscode());
        List<Map<String, Object>> hasrole = workFlowDao.getUserRoleBySytem(operatorId,obj.getSyscode());
        for (FlowRoleAction ra : l) {
            Boolean hasit = false;
            for (int i = 0; i < hasrole.size(); i++) {
                if (hasrole.get(i) != null
                        && hasrole.get(i).get("usergroup") != null
                        && hasrole.get(i).get("usergroup").toString().equals(
                        ra.getRole()))
                    hasit = true;
            }
            if (hasit && !roles.contains(ra.getRole()))
                roles.add(ra.getRole());
        }
        return roles;
    }

    public boolean getUserHasRole(String catalog, String rolename, String empid) {
//        Map<String, String> pMap = new HashMap<String, String>();
//        pMap.put("empid", empid);
//        pMap.put("catalog", catalog);
//        pMap.put("rolename", rolename);
//        List rolel = this.workFlowCommDao.findByNativeSQL(new Sql()
//                .addParameterEx(pMap, "getuserhasrole"));
        List rolel = workFlowDao.getUserHasRole(empid,catalog,rolename);
        if (rolel != null && rolel.size() > 0)
            return true;
        return false;
    }

//    public List<FlowRoleAction> findActFrRoleNode(long nodeid, String role,
//                                                  int cortype) {
//        List<FlowRoleAction> l = new ArrayList<FlowRoleAction>();
//        String sql = "from FlowRoleAction ra where ra.nodeId = " + nodeid
//                + " and ra.role = '" + role + "' ";
//        if (cortype == 0)
//            sql = sql
//                    + "and (ra.actionId.actionType <> 'CORACTION' and ra.actionId.actionType <> 'PICKACTION')";// 非协办
//        if (cortype == 1)
//            sql = sql + "and ra.actionId.actionType = 'CORACTION'";// 协办
//        if (cortype == 2)
//            sql = sql + "and ra.actionId.actionType = 'PICKACTION'";// 任务池
//        sql = sql + " order by ra.roleActionId";
//       // l = this.workFlowCommDao.find(sql);
//        return l;
//    }

    public List<FlowAction> findActByNodeId(long nodeid) {
        List<FlowAction> l = new ArrayList<FlowAction>();
        l = this.flowActionDao.listFlowActionByNodeId(nodeid);
        return l;
    }

    public List<String> findActDcideStrByNodeId(long nodeid) {
        List<String> l = new ArrayList<String>();
//        String sql = "select distinct ac.decideStr from FlowAction ac where ac.decideStr is not null and ac.nodeId = "
//                + nodeid;
        l = this.flowActionDao.listDecideStrBynodeId(nodeid);
        return l;
    }

    public List<String> getNextNodeMainRole(long actionid) {
        FlowAction action = flowActionDao.getFlowActionById(actionid);
        if (action == null)
            return null;
        FlowNode node = flowNodeDao.getFlowNode(action.getToNodeId());
        if (node == null)
            return null;
        if (action.getActionType() != null
                && action.getActionType().trim().equals("BACKACTION")) {

        }
        List<FlowRoleAction> l = flowRoleActionDao.listFlowRoleActionByNodeIdAndNodeId(node.getNodeId());
        List<String> roles = new ArrayList<String>();
        for (FlowRoleAction ra : l) {
            if (!roles.contains(ra.getRole())) {
                roles.add(ra.getRole());
            }
        }
        return roles;
    }

    public List<String> getNextNodeCorRole(long actionid) {
        List<String> roles = new ArrayList<String>();
        FlowAction action = flowActionDao.getFlowActionById(actionid);
        if (action == null)
            return roles;
        if (action.getCanMultiOperator() == 0)
            return roles;
        FlowNode node =  flowNodeDao.getFlowNode(action.getToNodeId());
        if (node == null)
            return roles;
        List<FlowRoleAction> l = flowRoleActionDao.listFlowRoleActionByNodeIdAndNodeId(node.getNodeId());

        for (FlowRoleAction ra : l) {
            if (!roles.contains(ra.getRole())) {
                roles.add(ra.getRole());
            }
        }
        return roles;
    }

    public List getNextNodeMainOpers(long actionid, String objType, long wfId,
                                     long taskId) {
        List<Map<String, Object>> rslt = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> userlist = null;
        ObjType obj = objTypeDao.getObjType(objType);
        if (obj == null)
            return rslt;
        List<String> roles = this.getNextNodeMainRole(actionid);
        for (String role : roles) {
            userlist =workFlowDao.getRoleUserMember(role);
            for (Map<String, Object> user : userlist) {
                Boolean hasuser = false;
                if (rslt.size() <= 0)
                    hasuser = true;
                if (user != null && user.get("EMPID") != null) {
                    hasuser = true;
                    for (Map<String, Object> rs : rslt) {
                        if (rs != null && rs.get("EMPID") != null
                                && user != null && user.get("EMPID") != null) {
                            if (rs.get("EMPID").toString().equals(
                                    user.get("EMPID").toString()))
                                hasuser = false;
                        }
                    }
                }

                if (hasuser)
                    rslt.add(user);
            }

        }
        return rslt;
    }

    public List getNextNodeCorOpers(long actionid, String objType, long wfId,
                                    long taskId) {
        List<Map<String, Object>> rslt = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> userlist = null;
        ObjType obj = objTypeDao.getObjType(objType);
        if (obj == null)
            return rslt;
        List<String> roles = this.getNextNodeCorRole(actionid);
        for (String role : roles) {
            userlist = new ArrayList<Map<String, Object>>();
//            Map pMap = new HashMap();
//            pMap.put("role", role);
            userlist = workFlowDao.getRoleUserMember(role);
            for (Map<String, Object> user : userlist) {
                Boolean hasuser = false;
                if (rslt.size() <= 0)
                    hasuser = true;
                if (user != null && user.get("EMPID") != null) {
                    hasuser = true;
                    for (Map<String, Object> rs : rslt) {
                        if (rs != null && rs.get("EMPID") != null
                                && user != null && user.get("EMPID") != null) {
                            if (rs.get("EMPID").toString().equals(
                                    user.get("EMPID").toString()))
                                hasuser = false;
                        }
                    }
                }

                if (hasuser)
                    rslt.add(user);
            }

        }
        return rslt;
    }

    public Long getFirstActionId(String objType) {
        Flow flow = (Flow) this.getFlowDefi(objType);
        if (flow != null) {
            List<Map<String, Object>> l = flowActionDao.listActionIdByFlowId(flow.getFlowId());
            if (l.size() > 0) {
                return l.get(0).get("ACTIONID") == null ? null : Long.valueOf(l
                        .get(0).get("ACTIONID").toString());
            }
        }
        return null;
    }

    public Object getFirstAction(String objType) {
        Flow flow = (Flow) this.getFlowDefi(objType);
        if (flow != null) {
            List<FlowAction> l = flowActionDao.listFlowActionIdByFlowId(flow.getFlowId());
            if (l.size() > 0) {
                return l.get(0);
            }
        }
        return null;
    }

    public void closeCorTaskByLogId(Long id, String comimsg) {
        wfTaskDao.updateWfTaskByWflogid(id);
        wfLogCorpDao.updateWfLogCorpByWflogid(id);
    }

    public void closeCorOAtodoByLogId(long id, String syscode) {
        List<WfTask> tsklist = wfTaskDao.listWfTaskByWfLogId(id);
        for (WfTask tsk : tsklist) {
            this.closeOAtodo(tsk, syscode);
        }
    }

    public void closeAllTaskByLogId(Long id) {

    }

    public Boolean checkIfOper(long wfId, String empid) {
        WorkFlow wf = (WorkFlow) this.findWorkFlowById(wfId);
        if (wf != null && wf.getOperatorID() != null
                && wf.getOperatorID().equals(empid))
            return true;
        return false;
    }

    public String getNodeNameByWfId(long wfId) {
        WorkFlow wf = (WorkFlow) this.findWorkFlowById(wfId);
        if (wf != null)
            return wf.getNodeName();
        else
            return "";
    }

//    public void saveObject(Object obj) {
//        this.workFlowCommDao.save(obj);
//    }
//
//    public void updateObject(Object obj) {
//        this.workFlowCommDao.update(obj);
//    }

    public void beginOAtodo(WfTask task, String updateby, String title,
                            String todomsg, String todourl, String syscode) {
        String taskid = String.valueOf(task.getWfTaskID());
        String processid = String.valueOf(task.getWfID());
       // todourl = todourl + "&wfId=" + processid + "&taskId=" + taskid;
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void closeOAtodo(WfTask task, String syscode) {
        String taskid = String.valueOf(task.getWfTaskID());
        String processid = String.valueOf(task.getWfID());
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }





}
