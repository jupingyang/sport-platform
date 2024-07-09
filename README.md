# 個人運動平台 ( 前端 Vue.js + 後端 Spring Boot )

### 專案簡介
 【個人健康平台】旨在提供使用者查詢各類運動可消耗的卡路里及各類食物的營養標示，以達到增肌減脂的營養目標。
 後台管理者能夠透過後台管理系統來管理已註冊會員。
 > 此專案為筆者參考 bilibili影片《个人健康平台》以 Spring Boot + Vue3 重構而成。

### 雲端部署
* 前端部署於 Github Pages：https://jupingyang.github.io/sport-platform-vue/dist/
* 後端部署於 GCP：https://still-lamp-428409-b4.de.r.appspot.com/menus ( 獲取所有菜單 )

### 後端使用技術
* Spring Boot：建立後端架構 
* MySQL/Mybatis：使用 MySQL 資料庫，並透過 Mybatis 來調用數據  
* 後台管理系統使用 controller, service, mapper 三層架構來處理請求及響應
* GCP：部署後端，建立 Cloud SQL 雲端資料庫

### 介面與功能
#### 前台：
* 註冊及登入會員
* 查詢各類運動可消耗卡路里
* 查詢各類食物營養標示
<img width="960" alt="login" src="https://github.com/jupingyang/sport-platform-vue/assets/88615992/28832087-4b90-485a-abed-33de6b29ea55">
<img width="960" alt="calories" src="https://github.com/jupingyang/sport-platform-vue/assets/88615992/5811a959-9c8e-4728-9201-9e65581444c5">
<img width="960" alt="food" src="https://github.com/jupingyang/sport-platform-vue/assets/88615992/a1385d67-1ca2-4d69-bf7d-6bf6bf1f9f0e">

#### 後台管理系統：
* 管理會員
* 修改用戶權限
<img width="960" alt="userList" src="https://github.com/jupingyang/sport-platform-vue/assets/88615992/05f717c9-7933-4303-a68e-8a22de62c282">
