# KU Tutor

> Project for 01418471 Software Engineering @ CS KU

KU Tutor เป็นแอพลิเคชั่นบน iOS สำหรับการค้นหาติวเตอร์และลงประกาศสำหรับสอนพิเศษได้โดยนิสิต หรือศิษย์เก่ามหาวิทยาลัยเกษตรศาสตร์
เพียงแค่ใช้บัญชี @ku.th ในการ Login เพื่อยืนยันตัวตนและกรอกข้อมูลก็สามารถใช้แอพลิเคชั่นนี้ได้

> [iOS Project on GitHub](https://github.com/peacher5/ku-tutor-ios)

## สมาชิกในกลุ่ม

1. `6010405360` พีรณัฐ วัฒนากุลศิริ
1. `6010405378` ภาสินี วสุพันธ์
1. `6010405432` วชิรวิทย์ อ่อนเชตุ
1. `6010405530` สุกฤตา อัครธเนศ

## Architecture

![](../assets/KU%20Tutor%20Architecture.png?raw=true)

## คำแนะนำในการติดตั้งและรัน KU Tutor Backend Server

### สิ่งที่ต้องมี

- [Docker](https://www.docker.com/get-started)
- Docker Compose

### วิธีรัน

1. Clone โปรเจคนี้ด้วยคำสั่ง `git clone https://github.com/peacher5/ku-tutor.git`
1. รันคำสั่ง `docker-compose up -d` เพื่อรัน server ซึ่งจะรันอยู่ที่ port 80
