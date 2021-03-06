package hana.ti.autotransfer.dao;

import java.util.List;

import hana.ti.autotransfer.vo.AutotransferVO;
import hana.ti.buy.vo.BuyVO;

public interface AutotransferDAO {
	/**
	 * 주금통 첫 번째 이체 신청 일반계좌 -> 증권계좌
	 * */
	public void send(AutotransferVO autotransferVO);
	
	/**
	 * 주금통 예약테이블에 있는 매일 저녁 6시에 맞춰 보내기
	 * */
	public void receive(AutotransferVO autotransferVO);

	/**
	 * 주금통 그날 남은 금액 업데이트
	 * */
	public void resUpdate(AutotransferVO autotransferVO);
	
	/**
	 * 주금통 내역 조회
	 * */
	public List<AutotransferVO> autoList(String fromAccount);
	
	/**
	 * 주금통 신청하면 예약테이블에 추가
	 * */
	public void insertRes(AutotransferVO autotransferVO);
	
	/**
	 * 예약테이블 리스트
	 * */
	public List<AutotransferVO> resTblList();
	
	/**
	 * 송금 내역에 추가
	 * */
	public void transferList(AutotransferVO autotransferVO);

	/**
	 * 주금통 서비스 증권계좌에 입금(내역에 추가)
	 * */
	public void deposite(AutotransferVO autotransferVO);
	
	/**
	 * 주금통 서비스 취소 -> 예약테이블에서 삭제
	 * */
	public void resSPDel(String fromAccount);
}
