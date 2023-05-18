// document.addEventListener('DOMContentLoaded', function() {
    // 페이지를 다 읽은 다음 실행 시킨다
    // 스크립트가 밑에 있으면 안써도 됨
    //   let liTag = document.createElement('li');
    //   liTag.innerText = 'Cherry';
    //   liTag.append()
    //   console.log(liTag);
    //   document.querySelector('#list').append(liTag);
    // })
    // javascript 객체 vs jQuery 객체
    $(document).ready(function () {
      // let elem = $('<li />'); // jQuery = $
      // elem.innerText : 에러
      // elem.text('Cherry');
      // console.log(elem);
      // 위의 줄을 밑의 문장으로 한번에 표현 가능
      $('#list').append($('<li />').text('Cherry'),
                        $('<li />').text('Mango'));
    })