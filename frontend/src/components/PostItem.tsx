// 게시글 하나를 표시하는 컴포넌트

// Props의 타입을 정의 (TypeScript)
type PostItemProps = {
  id: number
  title: string
  author: string
  date: string
}

function PostItem(props: PostItemProps) {
  return (
    <div
      style={{
        border: '1px solid #ddd',
        padding: '15px',
        marginBottom: '10px',
        borderRadius: '5px'
      }}
    >
      <h3>{props.title}</h3>
      <p style={{ color: '#666', fontSize: '14px' }}>
        작성자: {props.author} | 날짜: {props.date}
      </p>
    </div>
  )
}

export default PostItem