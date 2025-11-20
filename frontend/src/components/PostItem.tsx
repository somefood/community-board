// 게시글 하나를 표시하는 컴포넌트

// Props의 타입을 정의 (TypeScript)
type PostItemProps = {
  id: number
  title: string
  author: string
  date: string
  onClick: () => void  // 클릭 이벤트 핸들러
}

function PostItem({ title, author, date, onClick }: PostItemProps) {
  return (
    <div
      onClick={onClick}
      style={{
        border: '1px solid #ddd',
        padding: '15px',
        marginBottom: '10px',
        borderRadius: '5px',
        cursor: 'pointer',  // 마우스 커서를 손가락 모양으로
        transition: 'background-color 0.2s'  // 부드러운 효과
      }}
      onMouseEnter={(e) => {
        e.currentTarget.style.backgroundColor = '#f8f9fa'
      }}
      onMouseLeave={(e) => {
        e.currentTarget.style.backgroundColor = 'white'
      }}
    >
      <h3>{title}</h3>
      <p style={{ color: '#666', fontSize: '14px' }}>
        작성자: {author} | 날짜: {date}
      </p>
    </div>
  )
}

export default PostItem