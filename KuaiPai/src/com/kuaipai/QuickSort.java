package com.kuaipai;
import java.util.*;
/*
 * description: 快速排序quicksort
 * */
public class QuickSort{  
    private static int partition(int data[],int low,int high){//分治  
        int key = data[low];  
        while(low<high){  
            while(low<high && data[high]>=key)//从右向左  
                high--;  
                data[low] = data[high];  
                  
            while(low<high && data[low]<=key)//从左向右  
                low++;  
                data[high] = data[low];  
        }  
        data[low] = key;//把轴元素放在轴所在地位置  
        return low;//返回轴所在的位置  
    }  
      
    private  void quickSort(int data[],int low,int high){//递归  
        int q;  
        if(low<high){  
             q = partition(data,low,high);  
             quickSort(data,q+1,high);  
             quickSort(data,low,q-1);  
    }  
    }  
      
public static void main(String args[]){ 
    int len = 2000000;
    int arry[] = new int[len];
    //随机产生数据数组
    for(int i=0;i<len-1;i++){
    		int t = (int) (Math.random()*10000);
    		arry[i] = t;
    	}
    	QuickSort qs = new QuickSort();
    	//打印排序前时间
    	Calendar cal = Calendar.getInstance();
    	System.out.println("排序前"+cal.getTime());
    	//排序
    	qs.quickSort(arry,0,arry.length-1);

    	//重新得到实例
    	cal = Calendar.getInstance();
        System.out.println("排序后"+cal.getTime());
 
        
    }
}
