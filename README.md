### leetCode
#### array
- [BattleshipsInABoard.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/BattleshipsInABoard.java)  
思路：n个排在一列的算一个，m个排在一行的算一个，m个排在一行和n个排在一列的有空格

- [HIndex.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/HIndex.java)  
 tip: `` while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }``  
 - [CanPlaceFlowers.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/CanPlaceFlowers.java)  
 - [InsertInterval.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/InsertInterval.java)  
 思路: 无交集时直接加入到新的集合,有交集时取首尾的节点  
 - [IncreasingTripletSubsequence.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/IncreasingTripletSubsequence.java)  
 - [KEmptySlots.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/KEmptySlots.java)  
 - [SubarraySumEqualsK.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/SubarraySumEqualsK.java)  
   > tips:preSum+hashmap  
 - [PourWater.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/PourWater.java)  
 思路：先往左走，在往右走，找到单调递减为止  
 - [RelativeRanks.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/RelativeRanks.java)  
 思路：将socers和position放入对象链表中，按照scores降序，取得对应的position返回即可  
 - [NextGreaterElementI.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/NextGreaterElementI.java)   
 思路：借助hashmap和栈。当栈顶元素大于当前元素时，入栈；当栈顶元素小于当前元素时，说明栈顶元素找到了第一个大于的值，出栈，然后继续出栈直到栈顶元素大于当前元素，将当前元素入栈。  
 - [LargestNumberAtLeastTwice.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/LargestNumberAtLeastTwice.java)  
 -[SparseMatrixMultiplication.java
 (https://github.com/oceanhaiyang/j2se/blob/master/src/array/SparseMatrixMultiplication.java)  
 - [MinimumMovesToEqualArray.java](https://github.com/oceanhaiyang/j2se/blob/master/src/array/MinimumMovesToEqualArray.java)
  > 思路：先将数组排序，count += nums[j--] - nums[i++];

    
### jvm_quickStart

1.类的生命周期
  - 加载，连接，初始化

2.类的加载方式
  - 命令行启动时jvm初始化加载
  - Class.forName()动态加载
  - classLoder.loadClass()动态加载
  
3.自定义类加载器
  - 重写findClass方法即可，尽量不重写loadClass方法，会破坏双亲委托机制

4.jvm结束生命周期的情况
  - 执行了System.exit()方法
  - 程序正常执行结束
  - 程序在执行过程中遇到了异常或错误而异常终止
  - 由于操作系统出现错误而导致Java虚拟机进程终止

### fastjson和jackson的简单总结：

  - fastjson: 带有"{"是对象（jsonobject），带有"["是数组(jsonarray); 对象的解析用get或getstring ,数组解析用iterator;getJsonObjet或getJsonArray;Set<JsonObject>或Set<Map<K,V>>可以转成json.
  - jackson: 带有"{"是对象 ，带有"["是数组对象；一般deserialized为具有层次结构的javabeen.
 
