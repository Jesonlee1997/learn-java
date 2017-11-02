package com.longwo.econ.interbank.contagion.entrance;

/**功能的总入口
 * 
 * @author yeben
 *
 */
public class ToBeginSimulate {
	
	/**共同持有的资产 0.3d */
	private static final Double externalAssetInCommon = 0.3d;
			

	public static void main(String[] args) {
//		
//		//1 先进行有向网络的初始化
//		
//		//2 根据1中有向网络的节点代表银行，初始化银行的资产负债表
//		
//		//3初始化模拟开始前的参数和变量
//		
//		//4 进行多次(2000次)模拟，每次模拟的  过程中需要记录总的破产数量，然后进行单次的加总求和
//		
//		
//		//初始银行间贷出框请情况矩阵，
//		double [][] bankLiability = new double [5][5]; //定义了5行5列的二维数组 
//		bankLiability[0][0] = 0d; //给第一行第一个元素赋值 
//	    bankLiability[0][1] = 1d; //给第一行第二个元素赋值 
//	    bankLiability[0][2] = 0d; //给第一行第三个元素赋值 
//	    bankLiability[0][3] = 1d; 
//	    bankLiability[0][4] = 1d; 
//	      
//	    bankLiability[1][0] = 0d; //给第二行第一个元素赋值 
//	    bankLiability[1][1] = 0d; //给第二行第二个元素赋值 
//	    bankLiability[1][2] = 1d; //给第二行第三个元素赋值 
//	    bankLiability[1][3] = 0d;
//	    bankLiability[1][4] = 0d;
//	      
//	    bankLiability[2][0] = 1d; //给第三行第一个元素赋值 
//	    bankLiability[2][1] = 0d; //给第三行第二个元素赋值 
//	    bankLiability[2][2] = 0d; //给第三行第三个元素赋值 
//	    bankLiability[2][3] = 0d;
//	    bankLiability[2][4] = 0d;
//	    
//	    bankLiability[3][0] = 0d;//给第四行第一个元素赋值 
//	    bankLiability[3][1] = 1d;
//	    bankLiability[3][2] = 0d;
//	    bankLiability[3][3] = 0d;
//	    bankLiability[3][4] = 0d;
//	    
//	    bankLiability[4][0] = 0d;//给第五行第一个元素赋值 
//	    bankLiability[4][1] = 0d;
//	    bankLiability[4][2] = 1d;
//	    bankLiability[4][3] = 1d;
//	    bankLiability[4][4] = 0d;
//		
//		
//		Map<Integer,Bank> bankmapInit = Maps.newHashMap();
//		List<Bank> bankListInit = Lists.newArrayList();
//		Map<Integer,Double> lendingShortToBankMap = Maps.newHashMap();
//		Map<Integer,Double> lendingLongToBankMap = Maps.newHashMap();
//		Map<Integer,Double> borrowingShortFromBankMap = Maps.newHashMap();
//		Map<Integer,Double> borrowingLongFromBankMap = Maps.newHashMap();
//		
//		
//		Bank bank1 = new Bank();
//		bank1.setCapital(0.6d);
//		bank1.setCapitalInit(0.6d);
//		bank1.setDeposits(13.4d);
//		bank1.setBorrowingInit(1d);
//		bank1.setBorrowingShortTerm(0.5d);
//		bank1.setBorrowingLongTerm(0.5d);
//		bank1.setExternalAssetsInit(11.85d);
//		bank1.setExternalAssetInCommon(externalAssetInCommon);
//		bank1.setExternalAssetDistinctive(11.55d);
//		bank1.setLiquidAssets(0.15d);
//		bank1.setLendingInit(3d);
//		bank1.setLendingShortTerm(1.5d);
//		bank1.setLendingLongTerm(1.5d);
//		lendingShortToBankMap.put(2, 1d);
//		lendingShortToBankMap.put(4, 0.5d);
//		bank1.setLendingShortToBankMap(lendingShortToBankMap);
//		lendingLongToBankMap.put(5, 1d);
//		lendingLongToBankMap.put(4, 0.5d);
//		bank1.setLendingLongToBankMap(lendingLongToBankMap);
//		
//		borrowingShortFromBankMap.put(3,0.5d);
//		bank1.setBorrowingShortFromBankMap(borrowingShortFromBankMap);
//		borrowingLongFromBankMap.put(3,0.5d);
//		bank1.setBorrowingLongFromBankMap(borrowingLongFromBankMap);
//		
//		bankListInit.add(bank1);
//		bankmapInit.put(1, bank1);
//		
//		Bank bank2 = new Bank();
//		bank2.setCapital(0.2d);
//		bank2.setCapitalInit(0.2d);
//		bank2.setDeposits(3.8d);
//		bank2.setBorrowingInit(1d);
//		bank2.setBorrowingShortTerm(0.5d);
//		bank2.setBorrowingLongTerm(0.5d);
//		bank2.setExternalAssetsInit(3.95d);
//		bank2.setExternalAssetInCommon(externalAssetInCommon);
//		bank2.setExternalAssetDistinctive(3.65d);
//		bank2.setLiquidAssets(0.05d);
//		bank2.setLendingInit(1d);
//		bank2.setLendingShortTerm(0.5d);
//		bank2.setLendingLongTerm(0.5d);
//		lendingShortToBankMap = Maps.newHashMap();
//		lendingShortToBankMap.put(3,0.5d);
//		bank2.setLendingShortToBankMap(lendingShortToBankMap);
//		lendingLongToBankMap = Maps.newHashMap();
//		lendingLongToBankMap.put(3,0.5d);
//		bank2.setLendingLongToBankMap(lendingLongToBankMap);
//		
//		borrowingShortFromBankMap = Maps.newHashMap();
//		borrowingShortFromBankMap.put(1, 1d);
//		borrowingShortFromBankMap.put(4, 0.5d);
//		bank2.setBorrowingShortFromBankMap(borrowingShortFromBankMap);
//		borrowingLongFromBankMap = Maps.newHashMap();
//		borrowingLongFromBankMap.put(4, 0.5d);
//		bank2.setBorrowingLongFromBankMap(borrowingLongFromBankMap);
//		
//		bankListInit.add(bank2);
//		bankmapInit.put(2, bank2);
//		
//		Bank bank3 = new Bank();
//		bank3.setCapital(0.2d);
//		bank3.setCapitalInit(0.2d);
//		bank3.setDeposits(1.8d);
//		bank3.setBorrowingInit(3d);
//		bank3.setBorrowingShortTerm(1.5d);
//		bank3.setBorrowingLongTerm(1.5d);
//		bank3.setExternalAssetsInit(3.95d);
//		bank3.setExternalAssetInCommon(externalAssetInCommon);
//		bank3.setExternalAssetDistinctive(3.65d);
//		bank3.setLiquidAssets(0.05d);
//		bank3.setLendingInit(1d);
//		bank3.setLendingShortTerm(0.5d);
//		bank3.setLendingLongTerm(0.5d);
//		lendingShortToBankMap = Maps.newHashMap();
//		lendingShortToBankMap.put(1, 0.5d);
//		bank3.setLendingShortToBankMap(lendingShortToBankMap);
//		lendingLongToBankMap = Maps.newHashMap();
//		lendingLongToBankMap.put(1, 0.5d);
//		bank3.setLendingLongToBankMap(lendingLongToBankMap);
//	    
//		borrowingShortFromBankMap = Maps.newHashMap();
//		borrowingShortFromBankMap.put(2,0.5d);
//		borrowingShortFromBankMap.put(5,1d);
//		bank3.setBorrowingShortFromBankMap(borrowingShortFromBankMap);
//		borrowingLongFromBankMap = Maps.newHashMap();
//		borrowingLongFromBankMap.put(2,0.5d);
//		bank3.setBorrowingLongFromBankMap(borrowingLongFromBankMap);
//	
//		bankListInit.add(bank3);
//		bankmapInit.put(3, bank3);
//		
//		
//		Bank bank4 = new Bank();
//		bank4.setCapital(0.2d);
//		bank4.setCapitalInit(0.2d);
//		bank4.setDeposits(2.8d);
//		bank4.setBorrowingInit(1d);
//		bank4.setBorrowingShortTerm(1d);
//		bank4.setBorrowingLongTerm(1d);
//		bank4.setExternalAssetsInit(3.95d);
//		bank4.setExternalAssetInCommon(externalAssetInCommon);
//		bank4.setExternalAssetDistinctive(3.65d);
//		bank4.setLiquidAssets(0.05d);
//		bank4.setLendingInit(1d);
//		bank4.setLendingShortTerm(0.5d);
//		bank4.setLendingLongTerm(0.5d);
//	
//		lendingShortToBankMap = Maps.newHashMap();
//		lendingShortToBankMap.put(2, 0.5d);
//		bank4.setLendingShortToBankMap(lendingShortToBankMap);
//		lendingLongToBankMap = Maps.newHashMap();
//		lendingLongToBankMap.put(2, 0.5d);
//		bank4.setLendingLongToBankMap(lendingLongToBankMap);
//		
//		borrowingShortFromBankMap = Maps.newHashMap();
//		borrowingShortFromBankMap.put(1,0.5d);
//		bank4.setBorrowingShortFromBankMap(borrowingShortFromBankMap);
//		borrowingLongFromBankMap = Maps.newHashMap();
//		borrowingLongFromBankMap.put(5,1d);
//		borrowingLongFromBankMap.put(1,0.5d);
//		bank4.setBorrowingLongFromBankMap(borrowingLongFromBankMap);
//
//		bankListInit.add(bank4);
//		bankmapInit.put(4, bank4);
//		
//		Bank bank5 = new Bank();
//		bank5.setCapital(0.4d);
//		bank5.setCapitalInit(0.4d);
//		bank5.setDeposits(8.6d);
//		bank5.setBorrowingInit(1d);
//		bank5.setBorrowingShortTerm(1d);
//		bank5.setBorrowingLongTerm(1d);
//		bank5.setExternalAssetsInit(7.9d);
//		bank5.setExternalAssetInCommon(externalAssetInCommon);
//		bank5.setExternalAssetDistinctive(7.6d);
//		bank5.setLiquidAssets(0.1d);
//		bank5.setLendingInit(2d);
//		bank5.setLendingShortTerm(1d);
//		bank5.setLendingLongTerm(1d);
//		lendingShortToBankMap = Maps.newHashMap();
//		lendingShortToBankMap.put(3, 1d);
//		bank4.setLendingShortToBankMap(lendingShortToBankMap);
//		lendingLongToBankMap = Maps.newHashMap();
//		lendingLongToBankMap.put(4, 1d);
//		bank4.setLendingLongToBankMap(lendingLongToBankMap);
//	    
//		borrowingShortFromBankMap = Maps.newHashMap();
//		bank4.setBorrowingShortFromBankMap(borrowingShortFromBankMap);
//		borrowingLongFromBankMap = Maps.newHashMap();
//		borrowingLongFromBankMap.put(1,1d);
//		bank4.setBorrowingLongFromBankMap(borrowingLongFromBankMap);
//		
//		bankListInit.add(bank5);
//		bankmapInit.put(5, bank5);
//		
//		
//		
//		
//		//随机进行攻击某一个银行，让其 资本金capital=0
//		//先让 bank 3 的 capital=0
//		Bank bankDealing = bankmapInit.get(3);
//		bankDealing.setCapital(0d);
//		bankmapInit.put(3, bankDealing);
//		
//		List<Bank> listDealing = Lists.newArrayList();
//		
//		for(Map.Entry<Integer, Bank> entry : bankmapInit.entrySet())    {    
//			listDealing.add(entry.getValue());
//		} 
//		
//		//计算所有银行的健康情况
//		List<Bank> bankFailedList = BankStatusUtil.computeHealth4Bank(listDealing);
//		
//		
//		
//		 
		
		
		
		
		
		
		
		
		
		
		

	}

}
