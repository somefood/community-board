import { useState } from 'react'
import './App.css'
import PostItem from './components/PostItem'
import PostForm from './components/PostForm'

function App() {
  // State: 게시글 목록을 기억 (이제 변경 가능!)
  const [posts, setPosts] = useState([
    { id: 1, title: '첫 번째 게시글', author: '홍길동', date: '2024-11-20' },
    { id: 2, title: '리액트 공부 시작!', author: '김철수', date: '2024-11-20' },
    { id: 3, title: '커뮤니티 보드 만들기', author: '이영희', date: '2024-11-19' },
  ])

  // 새 게시글 추가 함수
  const handleAddPost = (title: string, author: string) => {
    const newPost = {
      id: posts.length + 1, // 간단한 ID 생성 (실제로는 서버에서 생성)
      title: title,
      author: author,
      date: new Date().toISOString().split('T')[0] // 오늘 날짜
    }

    // 기존 posts 배열에 새 게시글 추가
    setPosts([newPost, ...posts]) // 맨 앞에 추가
  }

  return (
    <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
      <h1>커뮤니티 게시판</h1>

      {/* 게시글 작성 폼 */}
      <PostForm onSubmit={handleAddPost} />

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
