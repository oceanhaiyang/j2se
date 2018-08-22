package dataStruct.ArrayListUnit;

/**
 *
 *  本题题意：存在以下的编码方式   问：给出一串数字，问能够分解出来的字符串有多少？
 *  'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 *
 *   本题思路：采用dp的思想。就和斐波那契数列差不多，d[i] = d[i-1] + d[i-2]，后面还有台阶的问题，基本都是一样的。
 *
 *   注意点：初始化的时候，要注意d[0] = 1;
 *   另外，判断两位数是否合理的时候，要判断是不是第一位是0
 */
public class DecodeWays061 {

	public int numDecodings(String s) {
		//f[i] = f[i-1] + f[i-2](if s[i-1] and s[i] can be a number)
		if(s == null) return 0;
		s = s.toUpperCase();
		//如果s的长度为0,那么就返回0
		int sLength = s.length();
		if(sLength == 0) return 0;

		//获取第一个字符
		String firstchar = s.substring(0,1);
		//如果第一个字符不是0,而且仅有这么一个字符  返回1
		if(sLength == 1 && !firstchar.equals("0")) return 1;

		if(firstchar.equals("0")) return 0;

		//声明f,并且进行初始化
		int[] f = new int[sLength+1];
		f[0] = 1;
		if(!firstchar.equals("0")){
			f[1] = 1;
		}

		int first = 0;
		int second = 0;
		//解题思路和斐波那契数列差不多  就是判断当前元素和自己前面的元素能否构成一个数
		for(int i = 2; i <= sLength; i++){
			//获取当前数和前面的一个数
			first = Integer.parseInt(s.substring(i-2,i-1));
			second = Integer.parseInt(s.substring(i-1,i));

			//判断当前的数和前面的数能够构成一个合理的数  如果可以  那么  suffix = f[i-2]
			int suffix = 0;
			int tempResult = 10 * first + second;
			if(tempResult <= 26 && tempResult > 0 && first != 0){
				suffix = f[i-2];
			}

			//看当前的数自己能够构成一个数，如果可以，那么prefix = f[i-1]
			int prefix = 0;
			if(second != 0){
				prefix = f[i-1];
			}


			f[i] = prefix+suffix;
		}

		return f[sLength];
	}
}
