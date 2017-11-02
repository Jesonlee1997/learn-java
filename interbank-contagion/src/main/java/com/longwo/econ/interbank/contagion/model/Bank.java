package com.longwo.econ.interbank.contagion.model;



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



/**银行实体
 * 
 * @author yeben
 *
 */
public class Bank implements Serializable {

	private static final long serialVersionUID = 3783224269950016069L;
	
	/**编号 id */
	private Long id;
	/**名称 */
	private String name;
	
	//资产部分

	/**银行外部资产之和 */
	private Double externalAssets;//外部资产不需要分为需要分为短期和长期
	/**初始的外部资产之和 */
	private Double externalAssetsInit;

	/**外部资产--共同持有 */
	private Double externalAssetInCommon = 0.3d;
	/**外部资产--独自持有 */
	private Double externalAssetDistinctive;
	
	/**流动性资产 */
	private Double liquidAssets;
	
	/**贷出款总额 */
	private Double lending; //需要分为短期和长期
	/**初始贷出款总额 */
	private Double lendingInit;
	/**贷出款--短期 */
	private Double lendingShortTerm;
	/**贷出款--长期 */
	private Double lendingLongTerm;
	
//	/**  短期贷出款列表*/
//	private List<Map> lendingShortTermList;
//	/** 长期期贷出款列表*/
//	private List<Map> lendingLongTermList;
//	
	/**  短期贷出款列表*/
	private Map<Integer,Double> lendingShortToBankMap = new HashMap<Integer,Double>();
	/** 长期期贷出款列表*/
	private Map<Integer,Double> lendingLongToBankMap = new HashMap<Integer,Double>();

	
	//负债部分
	/**当前资本 */
	private Double capital;
	/**初始资本 */
	private Double capitalInit;
	
	/**储蓄存款*/
	private Double deposits;
	
	/**当前借入款总额 */
	private Double borrowing;//需要分为短期和长期
	/**初始借入款 */
	private Double borrowingInit;
	/**短期借入款 */
	private Double borrowingShortTerm;
	/**长期借入款 */
	private Double borrowingLongTerm;
	
//	/**  短期借入款列表*/
//	private List<Map> borrowingShortTermList;
//	/** 长期期借入款列表*/
//	private List<Map> borrowingLongTermList;
	
	/**  短期借入款列表*/
	private Map<Integer,Double> borrowingShortFromBankMap = new HashMap<Integer,Double>();
	/** 长期期借入款列表*/
	private Map<Integer,Double> borrowingLongFromBankMap = new HashMap<Integer,Double>();
	
	/**银行当前的健康状况 */
	private Double health;
	
//	/**Map<Integer1,Integer2> 给银行Integer1贷出了数额为Integer2的钱*/
//	private Map<Integer,Double> lendingToBankMap;
//	
//	/**Map<Integer1,Integer2> 从银行 Integer1借来了数额为Integer2的钱*/
//	private Map<Integer,Double> borrowingFromBankMap;
//	

	
	
	
	public Bank() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getLiquidAssets() {
		return liquidAssets;
	}
	public void setLiquidAssets(Double liquidAssets) {
		this.liquidAssets = liquidAssets;
	}
	public Double getLending() {
		lending = lendingShortTerm + lendingLongTerm;
		return lending;
	}
	public void setLending(Double lending) {
		this.lending = lending;
	}
	public Double getCapital() {
		return capital;
	}
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	public Double getDeposits() {
		return deposits;
	}
	public void setDeposits(Double deposits) {
		this.deposits = deposits;
	}
	public Double getBorrowing() {
		borrowing = borrowingShortTerm + borrowingLongTerm;
		return borrowing;
	}
	public void setBorrowing(Double borrowing) {
		this.borrowing = borrowing;
	}
	
	public Double getExternalAssetDistinctive() {
		return externalAssetDistinctive;
	}
	public void setExternalAssetDistinctive(Double externalAssetDistinctive) {
		this.externalAssetDistinctive = externalAssetDistinctive;
	}
	public Double getExternalAssets() {
		
		externalAssets = externalAssetDistinctive + externalAssetInCommon;
		return externalAssets;
	}
	public void setExternalAssets(Double externalAssets) {
		this.externalAssets = externalAssets;
	}
	public Double getHealth() {
		return health;
	}
	public void setHealth(Double health) {
		this.health = health;
	}
	public Double getExternalAssetsInit() {
		return externalAssetsInit;
	}
	public void setExternalAssetsInit(Double externalAssetsInit) {
		this.externalAssetsInit = externalAssetsInit;
	}
	public Double getCapitalInit() {
		return capitalInit;
	}
	public void setCapitalInit(Double capitalInit) {
		this.capitalInit = capitalInit;
	}
	public Double getLendingInit() {
		return lendingInit;
	}
	public void setLendingInit(Double lendingInit) {
		this.lendingInit = lendingInit;
	}
	public Double getLendingShortTerm() {
		return lendingShortTerm;
	}
	public void setLendingShortTerm(Double lendingShortTerm) {
		this.lendingShortTerm = lendingShortTerm;
	}
	public Double getLendingLongTerm() {
		return lendingLongTerm;
	}
	public void setLendingLongTerm(Double lendingLongTerm) {
		this.lendingLongTerm = lendingLongTerm;
	}
	public Double getBorrowingInit() {
		return borrowingInit;
	}
	public void setBorrowingInit(Double borrowingInit) {
		this.borrowingInit = borrowingInit;
	}
	public Double getBorrowingShortTerm() {
		return borrowingShortTerm;
	}
	public void setBorrowingShortTerm(Double borrowingShortTerm) {
		this.borrowingShortTerm = borrowingShortTerm;
	}
	public Double getBorrowingLongTerm() {
		return borrowingLongTerm;
	}
	public void setBorrowingLongTerm(Double borrowingLongTerm) {
		this.borrowingLongTerm = borrowingLongTerm;
	}
	public Double getExternalAssetInCommon() {
		return externalAssetInCommon;
	}
	public void setExternalAssetInCommon(Double externalAssetInCommon) {
		this.externalAssetInCommon = externalAssetInCommon;
	}
//	public Map<Integer, Double> getLendingToBankMap() {
//		return lendingToBankMap;
//	}
//	public void setLendingToBankMap(Map<Integer, Double> lendingToBankMap) {
//		this.lendingToBankMap = lendingToBankMap;
//	}
//	public Map<Integer, Double> getBorrowingFromBankMap() {
//		return borrowingFromBankMap;
//	}
//	public void setBorrowingFromBankMap(Map<Integer, Double> borrowingFromBankMap) {
//		this.borrowingFromBankMap = borrowingFromBankMap;
//	}
	
	public Map<Integer, Double> getLendingShortToBankMap() {
		return lendingShortToBankMap;
	}
	public void setLendingShortToBankMap(Map<Integer, Double> lendingShortToBankMap) {
		this.lendingShortToBankMap = lendingShortToBankMap;
	}
	public Map<Integer, Double> getLendingLongToBankMap() {
		return lendingLongToBankMap;
	}
	public void setLendingLongToBankMap(Map<Integer, Double> lendingLongToBankMap) {
		this.lendingLongToBankMap = lendingLongToBankMap;
	}
	public Map<Integer, Double> getBorrowingShortFromBankMap() {
		return borrowingShortFromBankMap;
	}
	public void setBorrowingShortFromBankMap(
			Map<Integer, Double> borrowingShortFromBankMap) {
		this.borrowingShortFromBankMap = borrowingShortFromBankMap;
	}
	public Map<Integer, Double> getBorrowingLongFromBankMap() {
		return borrowingLongFromBankMap;
	}
	public void setBorrowingLongFromBankMap(
			Map<Integer, Double> borrowingLongFromBankMap) {
		this.borrowingLongFromBankMap = borrowingLongFromBankMap;
	}
	
	
	/**计算当前银行的资本情况
	 * 
	 * @return <=0 破产， >0 正常
	 */
	public int getCapitalStatus(){
		return this.capital.compareTo(0d);
	}
	/**短期资产是否满足短期债务
	 * 
	 * @return
	 */
	public int getLiabilityStatus(){
		Double shortAssetAll = this.lendingShortTerm + this.liquidAssets;
		return shortAssetAll.compareTo(this.borrowingShortTerm);
	}
	

}
