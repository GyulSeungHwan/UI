export default {
  name: 'my-board-read',
  template: `<div>
                    <table id="list">
                      <tr>
                          <td style="width:50px;">글제목</td>
                          <td>{{ item.title }}</td>
                      </tr>
                      <tr style="height:300px">
                        <td colspan="2">{{ item.content }}</td>
                      </tr>
                    </table>
                    <!-- <button style="float:right;" v-on:click="boardList">목록</button> -->
                    <router-link tag="button" style="float:right;" to="/boardList">목록</router-link>
                </div>`,
  props: ['item']
  // 기능이 아니라 페이지를 호출하기 때문에 methods는 필요없다
  // router.js에서 item이라고 해서 object가 아닌 item을 쓴다
}