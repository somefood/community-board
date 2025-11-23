import axios from 'axios'
import type { BoardResponse, BoardCreateRequest } from './types'

// axios 인스턴스 생성 (기본 설정)
const api = axios.create({
  baseURL: 'http://localhost:8080/api',  // 백엔드 서버 주소
  headers: {
    'Content-Type': 'application/json',
  },
})

// 모든 게시글 조회
export const getAllBoards = async (): Promise<BoardResponse[]> => {
  const response = await api.get<BoardResponse[]>('/boards')
  return response.data
}

// 게시글 하나 조회
export const getBoard = async (id: number): Promise<BoardResponse> => {
  const response = await api.get<BoardResponse>(`/boards/${id}`)
  return response.data
}

// 게시글 생성
export const createBoard = async (request: BoardCreateRequest): Promise<BoardResponse> => {
  const response = await api.post<BoardResponse>('/boards', request)
  return response.data
}

// 게시글 삭제
export const deleteBoard = async (id: number): Promise<void> => {
  await api.delete(`/boards/${id}`)
}
