//{name:"Hong",age:20} => Object.
const obj = {
  days: ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'],
  makeThead: function(){
    let thd = document.createElement('thead');
    let tr = document.createElement('tr');
    for(let day of this.days){
      let th = document.createElement('th');
      th.innerText=day;
      tr.append(th);
    }
    thd.append(tr);
    return thd;
  },
  makeTbody(month){
    let tbd = document.createElement('tbody');
    let tr = document.createElement('tr');
    for(let i = 0;i<getFirstDay(month);i++){
      tr.append(document.createElement('td'));
    }
    for(let i=1;i<=this.getLastDate(month);i++){
      let td = document.createElement('td');
      td.innerText = i;
      tr.append(td);
      if(i%7==0){
        tbd.append(tr);
        tr = document.createElement('tr');
      }
    }
    tbd.append(tr);
    console.log(tbd);
    return tbd;
  },
  makeTable(month,elem){
    let tbl = document.createElement('table');
    tbl.append(this.makeThead(month));
    tbl.append(this.makeTbody(month));
    //return tbl;
    elem.append(tbl);
  },
  getFirstDay(month=5){
    if(month==5){
      return 1;
    }else if(month==6){
      return 4;
    }
  },
  //월 정보를 받고 마지막날짜 반환해주는 함수
  getLastDate(month=5){
    if(month==5){
      return 31;
    }else if(month==6){
      return 30;
    }
  }

}
//#show에 하위요소로 붙여주겠다.
//show.append(obj.makeTable(6));
obj.makeTable(6,show);