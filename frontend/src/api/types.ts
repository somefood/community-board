// API 응답 타입 정의 (백엔드 BoardResponse와 동일)
export type BoardResponse = {
  id: number
  title: string
  content: string
  createdAt: string  // ISO 형식 날짜 문자열
  updatedAt: string | null
}

// 게시글 생성 요청 타입
export type BoardCreateRequest = {
  title: string
  content: string
}
