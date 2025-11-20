// 게시글 상세보기 컴포넌트

type PostDetailProps = {
  id: number
  title: string
  author: string
  date: string
  content: string
  onBack: () => void  // 목록으로 돌아가는 함수
}

function PostDetail({ title, author, date, content, onBack }: PostDetailProps) {
  return (
    <div>
      {/* 뒤로가기 버튼 */}
      <button
        onClick={onBack}
        style={{
          padding: '8px 16px',
          marginBottom: '20px',
          fontSize: '14px',
          backgroundColor: '#6c757d',
          color: 'white',
          border: 'none',
          borderRadius: '5px',
          cursor: 'pointer'
        }}
      >
        ← 목록으로
      </button>

      {/* 게시글 상세 내용 */}
      <div
        style={{
          border: '1px solid #ddd',
          padding: '20px',
          borderRadius: '5px'
        }}
      >
        <h2>{title}</h2>
        <p style={{ color: '#666', fontSize: '14px', marginBottom: '20px' }}>
          작성자: {author} | 날짜: {date}
        </p>
        <hr style={{ margin: '20px 0', border: 'none', borderTop: '1px solid #eee' }} />
        <div style={{ fontSize: '16px', lineHeight: '1.6' }}>
          {content}
        </div>
      </div>
    </div>
  )
}

export default PostDetail