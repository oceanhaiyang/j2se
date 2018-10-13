    1.ArrayList实现约瑟夫环
思路：使用list集合进行初始化，出队操作以及指针的移动十分方便

    2.腾讯笔试题 五笔字典排序 ：输入字母序列 输出其对应的索引值
思路：已知a的索引，求b的索引：因为a到b之间隔了以下四种情况的字符串：a后跟2字符的串有25个（aa，ab，...ay），a后跟2字符的串有25*25个(aaa, aab, ... ayy)，a后面跟3字符的串有25* 25* 25个(aaaa,aaab,...ayyy)，然后才是b，所以b的索引 = a的索引 + 25+25* 25+25* 25 *25 + 1，加1是因为b排在a和中间的字符之后1个

已知aa的索引，求ab的索引：同理，ab的索引 = aa索引 + 25 + 25* 25 + 1

已知aaa的索引，求aab的索引：同理，aab的索引 = aaa索引 + 25 + 15、已知aaaa的索引，求aaab的索引 = aaaa索引 + 1

至于aaaa，aaa，aa, a的索引由1: 可归纳为 字符串长度 - 1

所以：可用一个权重数组来表示修正后的进制：factor[4] = {1+25+25* 25+25* 25* 25, 1+25+25* 25, 1+25, 1}

3.输入1000以内的数，输出有多少对质数的和等于输入的正整数。
example:input 10
output 2

leetCode

   countAndSay
   fourSum
   addBinary
   判断一棵树是不是对称二叉树
   33. 搜索旋转排序数组

---------------------------------------------------------------------------

jvm_quickStart

1.类的生命周期
--| 加载，连接，初始化

2.类的加载方式
--|命令行启动时jvm初始化加载
   Class.forName()动态加载
   classLoder.loadClass()动态加载

3.自定义类加载器
重写findClass方法即可，尽量不重写loadClass方法，会破坏双亲委托机制

4.jvm结束生命周期的情况
--|执行了System.exit()方法
  程序正常执行结束
  程序在执行过程中遇到了异常或错误而异常终止
  由于操作系统出现错误而导致Java虚拟机进程终止
  
  ----------------------------------------------------------------------
  fastjson和jackson的简单总结：
  fastjson: 带有"{"是对象（jsonobject），带有"["是数组(jsonarray); 对象的解析用get或getstring ,数组解析用iterator;getJsonObjet或getJsonArray;Set<JsonObject>或Set<Map>可以转成json.
  jackson: 带有"{"是对象 ，带有"["是数组对象；一般deserialized为具有层次结构的javabeen.

