export default {
  name: 'my-board-write',
  template: `<div>
                     <table id="list">
                       <tr>
                           <td>글제목</td>
                           <td><input type="text" style="width:90%;" v-model="title"></td>
                       </tr>
                       <tr>
                           <td colspan="2">
                               <textarea style="width:100%;" v-model="content"></textarea>
                           </td>
                       </tr>
                     </table>
                     <router-link tag="button" style="float:right;" to="/boardList">목록</router-link>
                     <button style="float:right;" v-on:click="boardSave">저장</button>
               </div>`,
  data: function () {
    return {
      title: '',
      content: ''
    }
  },
  methods: {
    boardSave: function () {

      fetch('http://192.168.0.51:8081/myserver/boardInsert', {
        method: 'post',
        headers: {
          'Content-type': 'application/json'
        },
        body: JSON.stringify({title: this.title, content: this.content})
      })
      .then(response => response.json())
      .then(data => { // then - 결과를 성공했을때 실행시키는 것
        console.log(data);
        this.$router.push({name: 'boardList'});
      })
      .catch(err => console.log(err));

      // GET 방식으로 했던 것
      // fetch('http://192.168.0.51:8081/myserver/boardInsert?title=' + this.title + "&content=" + this.content)
      // .then(response => response.json())
      // .then(data => console.log(data))
      // .catch(err => console.log(err));

      // this.$router.push({name: 'boardList'}); // 강제로 경로를 요청
      // 비동기 방식이라서 fetch의 내용이 처리되기도 전에 실행되어 버린다
    }
  }
}