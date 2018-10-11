package graph;

import javafx.beans.binding.ObjectExpression;

import java.util.*;

public class PathOperation {

    Node[] nodesArray=null;

    /* 临时保存路径节点的栈 */
    Stack<Node> stack = new Stack<Node>();
    /* 存储路径的集合 */
    ArrayList<String[]> sers = new ArrayList<String[]>();
    /* 判断节点是否在栈中 */
    public  boolean isNodeInStack(Node node)
    {
        Iterator<Node> it = stack.iterator();
        while (it.hasNext()) {
            Node node1 = (Node) it.next();
            if (node == node1)
                return true;
        }
        return false;
    }

    public  void showAndSavePath()
    {
        Object[] o = stack.toArray();
        String[]oo=new String[o.length];
        for (int i = 0; i < o.length; i++) {
            Node nNode = (Node) o[i];
            oo[i]=nNode.getName();

            if(i < (o.length - 1))
                System.out.print(nNode.getName() + "->");
            else
                System.out.print(nNode.getName());
        }
        sers.add(oo); /* 转储 */
        System.out.println("\n");
    }

    /*
     * 寻找路径的方法
     * cNode: 当前的起始节点currentNode
     * pNode: 当前起始节点的上一节点previousNode
     * sNode: 最初的起始节点startNode
     * eNode: 终点endNode
     */
    public  boolean getPaths(Node cNode, Node pNode, Node sNode, Node eNode) {
        Node nNode = null;
        /* 如果符合条件判断说明出现环路，不能再顺着该路径继续寻路，返回false */
        if (cNode != null && pNode != null && cNode == pNode)
            return false;

        if (cNode != null) {
            int i = 0;
            /* 起始节点入栈 */
            stack.push(cNode);
            /* 如果该起始节点就是终点，说明找到一条路径 */
            if (cNode == eNode)
            {
                /* 转储并打印输出该路径，返回true */
                showAndSavePath();
                return true;
            }
            /* 如果不是,继续寻路 */
            else
            {
                /*
                 * 从与当前起始节点cNode有连接关系的节点集中按顺序遍历得到一个节点
                 * 作为下一次递归寻路时的起始节点
                 */
                nNode = cNode.getRelationNodes().get(i);
                while (nNode != null) {
                    /*
                     * 如果nNode是最初的起始节点或者nNode就是cNode的上一节点或者nNode已经在栈中 ，
                     * 说明产生环路 ，应重新在与当前起始节点有连接关系的节点集中寻找nNode
                     */
                    if (pNode != null
                            && (nNode == sNode || nNode == pNode || isNodeInStack(nNode))) {
                        i++;
                        if (i >= cNode.getRelationNodes().size())
                            nNode = null;
                        else
                            nNode = cNode.getRelationNodes().get(i);
                        continue;
                    }
                    /* 以nNode为新的起始节点，当前起始节点cNode为上一节点，递归调用寻路方法 */
                    if (getPaths(nNode, cNode, sNode, eNode))/* 递归调用 */
                    {
                        /* 如果找到一条路径，则弹出栈顶节点 */
                        stack.pop();
                    }
                    /* 继续在与cNode有连接关系的节点集中测试nNode */
                    i++;
                    if (i >= cNode.getRelationNodes().size())
                        nNode = null;
                    else
                        nNode = cNode.getRelationNodes().get(i);
                }
                /*
                 * 当遍历完所有与cNode有连接关系的节点后，
                 * 说明在以cNode为起始节点到终点的路径已经全部找到
                 */
                stack.pop();
                return false;
            }
        } else
            return false;
    }

    public int locateNode(String name){
        for(int v=0;v<nodesArray.length;v++)
            if(nodesArray[v].getName().equals(name))
                return v;
        return -1;
    }

    public ArrayList<String[]> findPaths(Set nodes,Set edges,String start,String end){

//        Map<String,String>[] nodes=(HashMap<String,String>[])nodess.toArray();
//        Map<String,String>[] edges=(HashMap<String,String>[])edgess.toArray();
        /*生成图的结点数组*/
        Iterator<Map<String,String>> iter = nodes.iterator();
        this.nodesArray = new Node[nodes.size()];
        int i=0;
        while(iter.hasNext()){
            String nodeName=iter.next().get("id");
            this.nodesArray[i]=new Node(nodeName);
            i++;
        }

        int s=locateNode(start);
        int e=locateNode(end);
        if(s+e<0){
            System.out.println("首结点或尾结点不在结点列表中！");
            return null;
        }
        Node startNode=nodesArray[s];
        Node endNode=nodesArray[e];

         /*生成图的邻接表*/
        iter=edges.iterator();
        while(iter.hasNext()){
            Map<String,String> edge= iter.next();
            int source=locateNode(edge.get("source"));
            int target=locateNode(edge.get("target"));
            nodesArray[source].addRelationNode(nodesArray[target]);
            nodesArray[target].addRelationNode(nodesArray[source]);
        }

        /* 开始搜索所有路径 */
        getPaths(startNode, null, startNode, endNode);
        return sers;
    }

    public static void main(String args[]){
//        结点集
        Set<Object> dataJa=new HashSet<>();
        Map dataMap=new HashMap();
        dataMap.put("id","AA");
        dataMap.put("name","AA");
        dataMap.put("category",2);
        dataJa.add(dataMap);
        Map dataMap2=new HashMap();
        dataMap2.put("id","BB");
        dataMap2.put("name","BB");
        dataMap2.put("category",2);
        dataJa.add(dataMap2);
        Map dataMap3=new HashMap();
        dataMap3.put("id","CC");
        dataMap3.put("name","CC");
        dataMap3.put("category",2);
        dataJa.add(dataMap3);
        Map dataMap4=new HashMap();
        dataMap4.put("id","DD");
        dataMap4.put("name","DD");
        dataMap4.put("category",2);
        dataJa.add(dataMap4);

//        边集
        Set<Object> linkSet=new HashSet<>();
        Map idMap = new HashMap();
        idMap.put("target","BB");
        idMap.put("source","DD");
        idMap.put("value","持股");
        linkSet.add(idMap);
        Map idMap2 = new HashMap();
        idMap2.put("target","BB");
        idMap2.put("source","AA");
        idMap2.put("value","持股");
        linkSet.add(idMap2);
        Map idMap3 = new HashMap();
        idMap3.put("target","CC");
        idMap3.put("source","AA");
        idMap3.put("value","持股");
        linkSet.add(idMap3);
        Map idMap4= new HashMap();
        idMap4.put("target","AA");
        idMap4.put("source","DD");
        idMap4.put("value","持股");
        linkSet.add(idMap4);
        Map idMap5= new HashMap();
        idMap5.put("target","BB");
        idMap5.put("source","CC");
        idMap5.put("value","持股");
        linkSet.add(idMap5);

//        查所有路径
        ArrayList<String[]> result=new PathOperation().findPaths(dataJa,linkSet,"CC","DD");
        System.out.println("所有的路径：");
        Iterator<String[]> iter=result.iterator();
        while (iter.hasNext()){
            System.out.println(Arrays.toString(iter.next()));
        }



    }

//    public  void main1(){
////        PathOperation2 paths=new PathOperation2();
////        paths.findPaths();
//
//         /* 定义节点关系 */
//        int nodeRalation[][] =
//                {
//                        {1},      //0
//                        {0,5,2,3},//1
//                        {1,4},    //2
//                        {1,4},    //3
//                        {2,3,5},  //4
//                        {1,4}     //5
//                };
//
//        /* 定义节点数组 */
//        Node[] node = new Node[nodeRalation.length];
//
//        for(int i=0;i<nodeRalation.length;i++)
//        {
//            node[i] = new Node("node" + i);
//        }
//
//        /* 定义与节点相关联的节点集合
//        * 即生成图*/
//        for(int i=0;i<nodeRalation.length;i++)
//        {
//            ArrayList<Node> List = new ArrayList<Node>();
//
//            for(int j=0;j<nodeRalation[i].length;j++)
//            {
//                List.add(node[nodeRalation[i][j]]);
//            }
//            node[i].setRelationNodes(List);
//            List = null;  //释放内存
//        }
//
//        /* 开始搜索所有路径 */
//        getPaths(node[0], null, node[0], node[4]);
//
//
//        System.out.println("所有路径：");
//        for(String[]path:sers)
//            System.out.println(Arrays.toString(path));
//    }




    class Node
    {

        public String name = null;
        public ArrayList<Node> relationNodes = new ArrayList<Node>();
        public Node(String name){
            this.setName(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Node> getRelationNodes() {
            return relationNodes;
        }

        public void setRelationNodes(ArrayList<Node> relationNodes) {
            this.relationNodes = relationNodes;
        }
        public void addRelationNode(Node node){
            this.relationNodes.add(node);
        }
    }


}
