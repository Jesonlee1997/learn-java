package com.longwo.econ.interbank.contagion.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.longwo.econ.interbank.contagion.model.Bank;

public class BankStatusUtil {
	
	/**判断当前银行是否资不抵债
	 * 
	 * @param bank
	 * @return true,false
	 */
	public static boolean isBankFailed(Bank bank){
		if( bank.getLiabilityStatus() <= 0 )  {
			return true;
		}else{
			return false;
		}
	}
	
	/**判断银行是否破产
	 * 
	 * @param bank
	 * @return
	 */
	public static boolean isBankrupt(Bank bank){
		if( bank.getLiabilityStatus() <= 0 )  {
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**判断当前系统是否可以停止（即就是  1再也没有新增银行都破产  或者2是所有银行都已经破产）
	 * 
	 * @param bankList
	 * @return
	 */
	public static boolean isSystemCouldStop(List<Bank> bankList){
		boolean result = true;
		if(bankList == null || bankList.size() <= 0){
			result = true;
		}else{
			Bank bank = null;
			for (Iterator iterator = bankList.iterator(); iterator.hasNext();) {
				 bank = ( Bank) iterator.next();
				 //如果至少存在一家银行没有破产则系统没有都破产
				 if( !isBankrupt(bank) ){
					 result = false;
					 break;
				 }
			}
		}
		return result;
	}
	
	/**计算系统中所有银行的健康情况
	 * 
	 * @param bankList
	 * @return bankFailedList
	 */
	public static List computeHealth4Bank(List<Bank> bankList){
		List<Bank> bankFailedList = new ArrayList<Bank>();
		Bank bank = null;
		Double health = 0d;
		Double c = 0d;
		Double m = 0d;
		for (Iterator iterator = bankList.iterator(); iterator.hasNext();) {
			 bank = (Bank) iterator.next();
			 if(bank.getCapital().compareTo(0d) == 0){
				 health = 0d;
			 }else{
				 c = (Double)bank.getCapital() / bank.getCapitalInit();
				 m = Math.min(1d, (bank.getLendingShortTerm() + bank.getLiquidAssets())/bank.getBorrowingShortTerm()  );
				 health = c * m; 
			 }
			 bank.setHealth(health);
			 if(health.compareTo(0d) == 0){
				 bankFailedList.add(bank);
			 }
		}
		return bankFailedList;
	}
	
	

}
