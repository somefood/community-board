import { useState } from 'react'

// Props 타입 정의
type PostFormProps = {
  onSubmit: (title: string, author: string) => void
}

function PostForm({ onSubmit }: PostFormProps) {
  // State: 제목과 작성자 입력값을 기억
  const [title, setTitle] = useState('')
  const [author, setAuthor] = useState('')

  // 폼 제출 이벤트 핸들러
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault() // 페이지 새로고침 방지

    // 입력값 검증
    if (title.trim() === '' || author.trim() === '') {
      alert('제목과 작성자를 모두 입력해주세요!')
      return
    }

    // 부모 컴포넌트에 데이터 전달
    onSubmit(title, author)

    // 입력 필드 초기화
    setTitle('')
    setAuthor('')
  }

  return (
    <form onSubmit={handleSubmit} style={{ marginBottom: '30px' }}>
      <h2>새 게시글 작성</h2>

      {/* 제목 입력 */}
      <div style={{ marginBottom: '10px' }}>
        <input
          type="text"
          placeholder="제목을 입력하세요"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          style={{
            width: '100%',
            padding: '10px',
            fontSize: '16px',
            border: '1px solid #ddd',
            borderRadius: '5px'
          }}
        />
      </div>

      {/* 작성자 입력 */}
      <div style={{ marginBottom: '10px' }}>
        <input
          type="text"
          placeholder="작성자 이름"
          value={author}
          onChange={(e) => setAuthor(e.target.value)}
          style={{
            width: '100%',
            padding: '10px',
            fontSize: '16px',
            border: '1px solid #ddd',
            borderRadius: '5px'
          }}
        />
      </div>

      {/* 제출 버튼 */}
      <button
        type="submit"
        style={{
          padding: '10px 20px',
          fontSize: '16px',
          backgroundColor: '#007bff',
          color: 'white',
          border: 'none',
          borderRadius: '5px',
          cursor: 'pointer'
        }}
      >
        게시글 작성
      </button>
    </form>
  )
}

export default PostForm