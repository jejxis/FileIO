package com.example.fileio

import java.io.*

class FileUtil {
    fun readTextFile(fullPath: String): String{//외부 저장소 이용..권한 설정 필요
        val file = File(fullPath)
        if(!file.exists()) return ""

        val reader = FileReader(file)
        val buffer = BufferedReader(reader)//읽기 속도 향상

        var temp=""//buffer로 한 줄씩 읽은 내용 저장
        val result = StringBuffer()//모든 내용 저장

        while(true){
            temp = buffer.readLine()//버퍼로 한 줄 읽은거 템프에 저장
            if(temp == null) break;//템프가 비어 있으면 루프 탈출
            else result.append(buffer)//아니면 읽은 내용 추가해서 저장
        }

        buffer.close()
        return result.toString()
    }

    fun writeTextFile(directory: String, filename: String, content: String){//외부 저장소 이용.. 권한 설정 필요
        val dir = File(directory)//파일 객체 생성
        if(!dir.exists()){//해당 경로의 디렉토리가 존재하지 않는다면
            dir.mkdirs()//만든다.
        }
        val writer = FileWriter(directory+"/"+filename)
        val buffer = BufferedWriter(writer)//쓰기 속도 향상
        buffer.write(content)//내용 쓰기
        buffer.close()//버퍼 닫기
    }
}