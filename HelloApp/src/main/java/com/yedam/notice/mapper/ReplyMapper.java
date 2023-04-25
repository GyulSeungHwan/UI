package com.yedam.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int noticeId);
	// 댓글등록
	public int insertReply(ReplyVO vo);
	// 댓글삭제
	public int removeReply(int replyId);
	
	public int updateReply(@Param("replyId") int replyId, @Param("reply") String reply);
	
	public int updateReply(ReplyVO vo);
	
	public ReplyVO searchReply(int replyId);
}
