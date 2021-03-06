package hana.ti.account.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hana.ti.account.vo.AccountVO;
import hana.ti.autotransfer.vo.AutotransferVO;

@Repository
public class AccountDAOImpl implements AccountDAO {


	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 통합계좌조회
	 * */
	@Override
	public List<AccountVO> selectAll(String id) {
		List<AccountVO> accountList = sqlSession.selectList("account.dao.AccountDAO.selectAll", id);
		return accountList;
	}
	
	/**
	 * 총자산 조회
	 * */
	@Override
	public int sum(String id) {
		int sumTotal = sqlSession.selectOne("account.dao.AccountDAO.sum", id);
		return sumTotal;
	}

	/**
	 * 주금통 서비스 이용 X 통합계좌조회
	 * */
	@Override
	public List<AccountVO> selectAllNotReg(String id) {
		List<AccountVO> accountNotRegList = sqlSession.selectList("account.dao.AccountDAO.selectAllNotReg", id);
		return accountNotRegList;
	}

	/**
	 * 증권계좌개설
	 * */
	@Override
	public void create(AccountVO account) {
		sqlSession.insert("account.dao.AccountDAO.create", account);
	}
	
	/**
	 * 증권계좌조회
	 * */
	@Override
	public List<AccountVO> selectSAll(String id) {
		List<AccountVO> SAccountList = sqlSession.selectList("account.dao.AccountDAO.selectSAll", id);
		return SAccountList;
	}
	
	/**
	 * 증권계좌 잔액 조회
	 * */
	@Override
	public int sbalance(String id) {
		int saccbalance = sqlSession.selectOne("account.dao.AccountDAO.sbalance", id);
		return saccbalance;
	}
	
	/**
	 * 주금통 서비스 이용 O 통합계좌조회
	 * */
	@Override
	public List<AccountVO> regA(String id) {
		List<AccountVO> regList = sqlSession.selectList("account.dao.AccountDAO.regA", id);
		return regList;
	}

	/**
	 * 주금통 등록 타입 'N' -> 'Y'
	 * */
	@Override
	public void resSP(String fromAccount) {
		sqlSession.update("account.dao.AccountDAO.regSP", fromAccount);
	}

	/**
	 * 주금통 해지
	 * */
	@Override
	public void unRegSP(String account_num) {
		sqlSession.update("account.dao.AccountDAO.unRegSP", account_num);		
	}
	

	/**
	 * 주금통 총 모은 금액
	 * */
	@Override
	public int howmuchSP(String account_num) {
		int howmuchSP = sqlSession.selectOne("account.dao.AccountDAO.howmuchSP", account_num);
		return howmuchSP;
	}

	/**
	 * 주금통 현황
	 * */
	@Override
	public List<Integer> mySP(String account_num) {
		List<Integer> mySPList = sqlSession.selectList("account.dao.AccountDAO.mySP", account_num);
		return mySPList;
	}
}