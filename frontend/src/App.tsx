import { useState, useEffect } from 'react'
import './App.css'
import PostItem from './components/PostItem'
import PostForm from './components/PostForm'
import PostDetail from './components/PostDetail'
import * as boardApi from './api/boardApi'
import type { BoardResponse } from './api/types'

function App() {
  // State: 게시글 목록
  const [posts, setPosts] = useState<BoardResponse[]>([])

  // State: 로딩 상태
  const [loading, setLoading] = useState(true)

  // State: 에러 상태
  const [error, setError] = useState<string | null>(null)

  // State: 선택된 게시글 ID (null이면 목록 보기)
  const [selectedPostId, setSelectedPostId] = useState<number | null>(null)

  // useEffect: 컴포넌트가 처음 렌더링될 때 게시글 목록 가져오기
  useEffect(() => {
    loadPosts()
  }, [])  // 빈 배열 = 처음 한 번만 실행

  // 게시글 목록 불러오기 함수
  const loadPosts = async () => {
    try {
      setLoading(true)
      setError(null)
      const data = await boardApi.getAllBoards()
      setPosts(data)
    } catch (err) {
      setError('게시글을 불러오는데 실패했습니다.')
      console.error(err)
    } finally {
      setLoading(false)
    }
  }

  // 새 게시글 추가 함수
  const handleAddPost = async (title: string, author: string) => {
    try {
      // 백엔드 API 호출
        await boardApi.createBoard({
            title: title,
            content: `작성자: ${author}\n\n새로 작성한 게시글의 내용입니다.`
        });
// 게시글 목록 새로고침
        loadPosts()
    } catch (err) {
      alert('게시글 작성에 실패했습니다.')
      console.error(err)
    }
  }

  // 선택된 게시글 찾기
  const selectedPost = posts.find(post => post.id === selectedPostId)

  // 날짜 포맷 변환 함수 (ISO 문자열 → YYYY-MM-DD)
  const formatDate = (isoString: string) => {
    return isoString.split('T')[0]
  }

  return (
    <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px' }}>
      <h1>커뮤니티 게시판</h1>

      {/* 로딩 상태 */}
      {loading && (
        <div style={{ textAlign: 'center', padding: '40px' }}>
          <p>로딩 중...</p>
        </div>
      )}

      {/* 에러 상태 */}
      {error && (
        <div style={{ padding: '20px', backgroundColor: '#ffe6e6', borderRadius: '5px' }}>
          <p style={{ color: '#cc0000' }}>{error}</p>
          <button onClick={loadPosts}>다시 시도</button>
        </div>
      )}

      {/* 데이터 로딩 완료 */}
      {!loading && !error && (
        <>
          {/* 조건부 렌더링 1: 삼항 연산자 사용 */}
          {selectedPost ? (
            // 게시글이 선택되었으면 → 상세보기
            <PostDetail
              id={selectedPost.id}
              title={selectedPost.title}
              author="작성자"
              date={formatDate(selectedPost.createdAt)}
              content={selectedPost.content}
              onBack={() => setSelectedPostId(null)}
            />
          ) : (
            // 선택 안 되었으면 → 목록 보기
            <>
              {/* 게시글 작성 폼 */}
              <PostForm onSubmit={handleAddPost} />

              {/* 게시글이 없을 때 */}
              {posts.length === 0 && (
                <div style={{ textAlign: 'center', padding: '40px', color: '#999' }}>
                  <p>게시글이 없습니다. 첫 게시글을 작성해보세요!</p>
                </div>
              )}

              {/* 게시글 목록 */}
              <div>
                {posts.map((post) => (
                  <PostItem
                    key={post.id}
                    id={post.id}
                    title={post.title}
                    author="작성자"
                    date={formatDate(post.createdAt)}
                    onClick={() => setSelectedPostId(post.id)}
                  />
                ))}
              </div>
            </>
          )}
        </>
      )}
    </div>
  )
}

export default App
