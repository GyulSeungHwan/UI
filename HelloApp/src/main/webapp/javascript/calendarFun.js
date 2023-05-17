let mon = 5;
    let days = ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'];
    
    function makeCalendar(month = 1){
      //table 생성
      let tbl = document.createElement('table');
          tbl.border = '1';
          //thead생성
          let thd = document.createElement('thead');
          //tr생성
          let tr = document.createElement('tr');
          //th생성
          for(let day of days){
            let th = document.createElement('th');
            th.innerText = day;
            tr.append(th);
          }
          thd.append(tr);
          tbl.append(thd);
          tr = document.createElement('tr');
          for(let i = 0;i<getFirstDay(month);i++){
            tr.append(document.createElement('td'));
          }
          for(let i=1;i<=getLastDate(month);i++){
            let th = document.createElement('td');
            th.innerText = i;
            tr.append(th);
            if((i+getFirstDay(month))%7 ==0){
              thd.append(tr);
              tr = document.createElement('tr');
            }
            //Dom 을 활용해서 달력생성
          }
          tbd.append(tr);
          tbl.append(tbd);
          return tbl;
    }
    makeCalendar(5);
    //#show 하위 요소로 등록
    document.getElementById('show').append(makeCalendar(5));
    //월 정보를 받고 첫번째 날짜의 값을 반환해주는 함수.
    function getFirstDay(month=5){
      if(month==5){
        return 1;
      }else if(month==6){
        return 4;
      }
    }
    //월 정보를 받고 마지막날짜 반환해주는 함수
    function getLastDate(month=5){
      if(month==5){
        return 31;
      }else if(month==6){
        return 30;
      }
    }