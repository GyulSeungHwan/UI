// multipart request
function deleteRow() {
	// ajax 호출 id를 기준으로 삭제 후 화면에서 제거
	let tr = $(this).closest('tr')
	let id = tr.children().eq(0).text();
	$.ajax({
		url: 'delNoticeJson.do?nid=' + id,
		dataType: 'html', // Success, Fail
		error: function(xhr) {
			console.log(xhr);
		},
		success: function(result) {
			if (result == 'Success') {
				console.log(tr);
				tr.remove();
			} else if (result == 'Fail') {
				alert('처리 에러');
			} else {
				alert('알 수 없는 반환');
			}
		}
	})
		.always(function() {
			console.log('final')
		})
}

$(document).ready(function() {

	// modal 처리 라이브 이벤트처리
	$('#noticeList').on('dblclick', 'tr', function() {
		// ajax nid=> 활용
		let id = $(this).children().eq(0).text();
		console.log(id);
		$.ajax({
			url: 'getNoticeJson.do?nid=' + id,
			dataType: 'json',
			error: function(xhr) {
				console.log(xhr);
			},
			success: function(data) {
				console.log(data);
				$('.nid').text(data.noticeId);
				$('.nTitle').text(data.noticeTitle);
				$('.nWriter').text(data.noticeWriter);
				$('.nSubject').val(data.noticeSubject);
				$('.nAttach').css('width', '100px', 'height', '100px').attr('src', 'images/' + data.attachFile);
			}
		})

		$('#myModal').slideDown(500);//css('display', 'block');
	})

	$('span.close').on('click', function() {
		$('#myModal').css('display', 'none');
	})

	$(window).on('click', function(e) {
		console.log(e.target, $('#myModal')[0]);
		if (e.target == $('#myModal')[0]) {
			$('#myModal').css('display', 'none');
		}
	})

	// modal 창에 있는 이미지 클릭
	$('img.nAttach').on('click', function() {
		$('#attachFile').click(); // trigger event
	})

	// 파일선택하면 change 이벤트
	$('#attachFile').on('change', function (e) {
		// 게시글번호, 파일 => 서버전송 : noticeId 기준으로 attach 수정
		console.log(e.target.files[0]);
		
		let data = new FormData();
		data.append('nid', $('.nid').text());
		data.append('nfile', e.target.files[0]);
		
		console.log(data);
		$.ajax({
			url: 'modifyNoticeFile.do',
			method: 'post',
			data: data,
			// multipart요청
			contentType: false,
			processData: false,
			error: function () {
				
			},
			success: function () {
				
			}
		});
	})

	// 등록버튼 클릭
	$('form').on('submit', function(e) {
		e.preventDefault(); // form.submit 기능 차단
		var frm = $('form')[0];
		// $(frm).find('input[name="job"]').value('multi');
		var data = new FormData(frm); // multipart/form-data 처리하는 객체
		for (let val of data.entries()) {
			console.log(val);
		}
		$.ajax({
			url: 'addNotice.do',
			method: 'post',
			data: data,
			// multipart요청
			contentType: false,
			processData: false,
			error: function(jqxhr) {
				console.log(jqxhr.responseText);
			},
			success: function(data, status, xhr) {
				let val = data.retVal;
				if (data.retCode == 'Success') {
					let tr = $('<tr />').append(
						$('<td />').text(val.noticeId),
						$('<td />').text(val.noticeTitle),
						$('<td />').text(val.noticeWriter),
						$('<td />').append(
							($('<img>')).css('width', '50px').attr('src', 'images/' + val.attachFile)
						),
						$('<td />').append($('<button />').text('삭제').on('click', deleteRow))
					);
					$('#noticeList').prepend(tr);
					$('form')[0].reset(); // 폼의 reset 이벤트 호출
					// 위에서 frm = $('form')[0]이라고 선언해서 frm.reset();도 된다
				} else if (data.retCode == 'Fail') {
					alert('처리중 에러');
				} else {
					alert('알 수 없는 반환값');
				}
				// $('form').after($('<p />').text(
				// 	"작성자: " + data.retVal.noticeWriter +
				// 	"제목: " + data.retVal.noticeTie +
				// 	"파일: " + data.retVal.attachFile
				// ));
			}
		})
			.always(function() {
				console.log('final');
			})
	}); // end of 등록버튼

	// 공지목록 출력
	$.ajax({
		url: 'noticeListJson.do',
		method: 'GET',
		dataType: 'json',
		error: function(xhr) {
			console.log(xhr.responseText);
		},
		success: function(data) {
			console.log(data);
			data.forEach(function(notice) {
				let tr = $('<tr />').append(
					$('<td />').text(notice.noticeId),
					$('<td />').text(notice.noticeTitle),
					$('<td />').text(notice.noticeWriter),
					$('<td />').append(
						($('<img>')).css('width', '50px').attr('src', 'images/' + notice.attachFile)
					),
					$('<td />').append($('<button />').text('삭제').on('click', deleteRow))
				)
				$('#noticeList').append(tr);
			})
		}
	})

})