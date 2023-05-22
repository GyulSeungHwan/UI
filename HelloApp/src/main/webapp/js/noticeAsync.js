/**
 * noticeAsync.js
 */
// aysnc function()...

//async function loadData() { // async가 없다면 await는 에러가 난다
//	let promise = await fetch('noticeListJson.do');
//	let promise1 = await promise.json(); // json -> object
	let fields = ['noticeId', 'noticeTitle', 'noticeWriter', 'attachFile']
	promise1.forEach(function (item) {
		console.log(item);
		let tr = document.createElement('tr');
		for(let prop of fields) {
			let td = document.createElement('td');
			td.innerText = item[prop];
			tr.append(td);
		}
		document.getElementById('noticeList').append(tr);
	});
//}

document.addEventListener('DOMContentLoaded', function () {
	loadData();
})