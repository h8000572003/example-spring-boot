import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'
// https://vitejs.dev/config/
export default defineConfig({
  base:'./',
  plugins: [react()],
  resolve: {
    alias: {
      // 將 `src` 別名解析為相對於當前工作目錄的 `src` 目錄
      'src': path.resolve(__dirname, './src')
    }
  } ,
  server: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        ws:true,
      }
    }
  },
  build: {
    outDir: 'build',
  }
})

