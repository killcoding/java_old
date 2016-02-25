package com.kuaipai;
import java.util.*;
/*
 * description: ��������quicksort
 * */
public class QuickSort{  
    private static int partition(int data[],int low,int high){//����  
        int key = data[low];  
        while(low<high){  
            while(low<high && data[high]>=key)//��������  
                high--;  
                data[low] = data[high];  
                  
            while(low<high && data[low]<=key)//��������  
                low++;  
                data[high] = data[low];  
        }  
        data[low] = key;//����Ԫ�ط��������ڵ�λ��  
        return low;//���������ڵ�λ��  
    }  
      
    private  void quickSort(int data[],int low,int high){//�ݹ�  
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
    //���������������
    for(int i=0;i<len-1;i++){
    		int t = (int) (Math.random()*10000);
    		arry[i] = t;
    	}
    	QuickSort qs = new QuickSort();
    	//��ӡ����ǰʱ��
    	Calendar cal = Calendar.getInstance();
    	System.out.println("����ǰ"+cal.getTime());
    	//����
    	qs.quickSort(arry,0,arry.length-1);

    	//���µõ�ʵ��
    	cal = Calendar.getInstance();
        System.out.println("�����"+cal.getTime());
 
        
    }
}
