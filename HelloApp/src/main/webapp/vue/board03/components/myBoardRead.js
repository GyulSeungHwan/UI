export default {
  name: 'my-board-read',
  template: `<div>
                    <table id="list">
                      <tr>
                          <td style="width:50px;">글제목</td>
                          <td>{{ board.title }}</td>
                      </tr>
                      <tr style="height:300px">
                        <td colspan="2">{{ board.content }}</td>
                      </tr>
                    </table>
                    <!-- <button style="float:right;" v-on:click="boardList">목록</button> -->
                    <router-link tag="button" style="float:right;" v-bind:to="{name: 'boardList'}">목록</router-link>
                </div>`,
  data: function() {
    return {
      board: {}
    }
  },
  props: ['item'],
  // 기능이 아니라 페이지를 호출하기 때문에 methods는 필요없다
  // router.js에서 item이라고 해서 object가 아닌 item을 쓴다
  created: function() {
    fetch('http://192.168.0.51:8081/myserver/boardInfo?no=' + this.item.no)
    .then(response => response.json())
    .then(data => {
      this.board = data;
    })
    .catch(err => console.log(err));
    // catch를 빼먹지말기(적지 않으면 오류가 나도 알려주지않음)
  }
}