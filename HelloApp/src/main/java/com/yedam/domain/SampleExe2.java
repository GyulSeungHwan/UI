package com.yedam.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.member.mapper.MemberMapper;

public class SampleExe2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			List<Map<String, Object>> list = mapper.memberByDept();
			// [{Adminstration, 1}, {Accounting, 2}....{}]
			for (Map<String, Object> map : list) {
				Set<String> set = map.keySet();
//				for (String key : set) {
//					System.out.println(key + " : " + map.get(key));
					System.out.println(map.get("DEPARTMENT_NAME") + ", " + map.get("CNT"));
//				}
			}
//		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
//		try (SqlSession session = sqlSessionFactory.openSession(true)) {
//			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
//			NoticeVO nvo = new NoticeVO();
//			nvo.setNoticeWriter("user00");
//			nvo.setNoticeTitle("re:tttest");
//			nvo.setNoticeSubject("re:글내용입니다....아.");
//			mapper.insertNotice(nvo);
//			mapper.updateNotice(nvo);
//			mapper.deleteNotice(9);
//			System.out.println(mapper.searchNotice(3));
//			
//			for(NoticeVO vo : mapper.noticeList()) {
//				System.out.println(vo);
//			}
//			Employee emp = mapper.getEmp(100);
//			Employee empl = new Employee();
//			empl.setEmployeeId(310);
//			empl.setLastName("Hong");
//			empl.setEmail("hon1@email");
//			empl.setJobId("IT_PROG");
//			
//			mapper.addEmp(empl);
//			session.commit();
//			
//			Employee emp = mapper.getEmp(310);
//			System.out.println(emp);
		}
	}
}
