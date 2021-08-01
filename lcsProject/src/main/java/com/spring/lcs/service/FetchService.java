package com.spring.lcs.service;

public class FetchService {

	public String findLCS(String str1, String str2, String str3)
	{
		int maxlen = 0; 		
		int m = str1.length(), n = str2.length(), o = str3.length();
		int endingIndex = m;
		int[][][] lookup = new int[m + 1][n + 1][o + 1];

		for (int i = 1; i <= m; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				for (int k = 1; k <= o; k++)
				{
				if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) == str2.charAt(k - 1) )
				{
					lookup[i][j][k] = lookup[i - 1][j - 1][k - 1] + 1;

					if (lookup[i][j][k] > maxlen)
					{
						maxlen = lookup[i][j][k];
						endingIndex = i;
					}
				}
			    }
		     }
	      }
		return str1.substring(endingIndex - maxlen, endingIndex);
	}
	
}
