# Rest-API-SpringBoot-UTS
Cara Deploy ke Docke
Tahap 1 PERSIAPAN
  1. Jadikan API menjadi bentuk jar terlebih dahulu (di ubuntu bisa pakai command: mvn install)
  2. Setelah mvn install, Akan ada tergenerate direktori target dan didalamnya ada file jar nya 
  3. Buat file DockerFile pada direktori utama adn tambahkan attribute seperti berikut: 
  FROM openjdk:11.0.8 #lihat dulu versi jdk yang ada dilaptop masing masing
  EXPOSE 8080
  ADD /target/UTS_REST_API-0.0.1-SNAPSHOT.jar UTS_REST_API-0.0.1-SNAPSHOT.jar #lokasi jar nya
  ENTRYPOINT ["java", "-jar", "UTS_REST_API-0.0.1-SNAPSHOT.jar"] #argumen ketiga merupakan nama jarnya
  
  Tahap 2 DEPLOY
  1. Build Image 
    Buka terminal dan ketikkan perintah: "docker build -f DockerFile -t itemapi . " #itemapi adalah nama images yang akan dibuat. harus lowercase
    Cek apakah image sudah terbuild : docker images
  2. Jalankan
    "docker run -p 8080:8080 itemapi"
    
   Apabila dilain waktu ingin menjalankan api nya, maka tinggal docker start saja (lihat terlebih dahulu container id nya)
   
   source : 
   https://dzone.com/articles/deploying-spring-boot-on-docker
