import { useState } from 'react'
import './App.css'
import PostItem from './components/PostItem'
import PostForm from './components/PostForm'
import PostDetail from './components/PostDetail'

function App() {
  // State: 게시글 목록을 기억 (이제 content도 포함!)
  const [posts, setPosts] = useState([
    {
      id: 1,
      title: '첫 번째 게시글',
      author: '홍길동',
      date: '2024-11-20',
      content: '안녕하세요! 첫 번째 게시글입니다. 리액트로 커뮤니티 게시판을 만들고 있어요.'
    },
    {
      id: 2,
      title: '리액트 공부 시작!',
      author: '김철수',
      date: '2024-11-20',
      content: '오늘부터 리액트 공부를 시작했습니다. State와 Props 개념이 재밌네요!'
    },
    {
      id: 3,
      title: '커뮤니티 보드 만들기',
      author: '이영희',
      date: '2024-11-19',
      content: '커뮤니티 게시판 프로젝트를 진행 중입니다. 많은 것을 배우고 있어요.'
    },
  ])

  // State: 선택된 게시글 ID (null이면 목록 보기)
  const [selectedPostId, setSelectedPostId] = useState<number | null>(null)

  // 새 게시글 추가 함수
  const handleAddPost = (title: string, author: string) => {
    const newPost = {
      id: posts.length + 1,
      title: title,
      author: author,
      date: new Date().toISOString().split('T')[0],
      content: '새로 작성한 게시글의 내용입니다.'
    }

    setPosts([newPost, ...posts])
  }

  // 선택된 게시글 찾기
  const selectedPost = posts.find(post => post.id === selectedPostId)

  return (
    <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
      <h1>커뮤니티 게시판</h1>

      {/* 조건부 렌더링 1: 삼항 연산자 사용 */}
      {selectedPost ? (
        // 게시글이 선택되었으면 → 상세보기
        <PostDetail
          id={selectedPost.id}
          title={selectedPost.title}
          author={selectedPost.author}
          date={selectedPost.date}
          content={selectedPost.content}
          onBack={() => setSelectedPostId(null)}
        />
      ) : (
        // 선택 안 되었으면 → 목록 보기
        <>
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
                onClick={() => setSelectedPostId(post.id)}
              />
            ))}
          </div>
        </>
      )}
    </div>
  )
}

export default App
