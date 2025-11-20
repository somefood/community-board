import './App.css'
import PostItem from './components/PostItem'

function App() {
  // 게시글 데이터 (나중에 서버에서 가져올 예정)
  const posts = [
    { id: 1, title: '첫 번째 게시글', author: '홍길동', date: '2024-11-20' },
    { id: 2, title: '리액트 공부 시작!', author: '김철수', date: '2024-11-20' },
    { id: 3, title: '커뮤니티 보드 만들기', author: '이영희', date: '2024-11-19' },
  ]

  return (
    <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
      <h1>커뮤니티 게시판</h1>

      {/* 게시글 목록 */}
      <div>
        {posts.map((post) => (
          <PostItem
            key={post.id}
            id={post.id}
            title={post.title}
            author={post.author}
            date={post.date}
          />
        ))}
      </div>
    </div>
  )
}

export default App
