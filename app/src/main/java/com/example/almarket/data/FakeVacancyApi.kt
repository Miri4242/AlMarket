package com.example.almarket.data

import com.example.almarket.model.Vacancy

object FakeVacancyApi{
    suspend fun getVacancies():List<Vacancy>{
        return listOf(
            Vacancy(1, "Kateqoriya müdiri", "Bakı", "30 apr 2025"),
            Vacancy(2, "Market Meneceri", "Sumqayıt", "12 may 2025"),
            Vacancy(3, "Satış Təmsilçisi", "Gəncə", "01 iyun 2025"),
            Vacancy(4, "Anbarçı", "Bakı", "15 may 2025"),
            Vacancy(5, "Mühafizəçi", "Xırdalan", "20 may 2025"),
            Vacancy(6, "Kassir", "Şəki", "25 may 2025"),
            Vacancy(7, "Satıcı", "Lənkəran", "05 iyun 2025"),
            Vacancy(8, "Məhsul Yerləşdirici", "Mingəçevir", "10 iyun 2025"),
            Vacancy(9, "Təhlükəsizlik əməkdaşı", "Naxçıvan", "15 iyun 2025"),
            Vacancy(10, "Ofis Meneceri", "Quba", "20 iyun 2025"),
            Vacancy(11, "HR üzrə mütəxəssis", "Bakı", "01 iyul 2025"),
            Vacancy(12, "IT dəstək", "Sumqayıt", "05 iyul 2025"),
            Vacancy(13, "Təmizlikçi", "Gəncə", "10 iyul 2025"),
            Vacancy(14, "Maliyyə Mütəxəssisi", "Şirvan", "15 iyul 2025"),
            Vacancy(15, "Reklam Meneceri", "Bakı", "20 iyul 2025"),
            Vacancy(16, "Sürücü", "Sumqayıt", "25 iyul 2025"),
            Vacancy(17, "Mağaza müdiri", "Şəki", "01 avq 2025"),
            Vacancy(18, "Çatdırıcı", "Lənkəran", "05 avq 2025"),
            Vacancy(19, "Texniki Dəstək", "Mingəçevir", "10 avq 2025"),
            Vacancy(20, "Anbar Müdiri", "Quba", "15 avq 2025"),
            Vacancy(21, "Tədris üzrə mütəxəssis", "Bakı", "20 avq 2025"),
            Vacancy(22, "Satış meneceri", "Gəncə", "25 avq 2025"),
            Vacancy(23, "Grafik Dizayner", "Sumqayıt", "01 sen 2025"),
            Vacancy(24, "Video Redaktor", "Bakı", "05 sen 2025"),
            Vacancy(25, "UX/UI Dizayner", "Naxçıvan", "10 sen 2025"),
            Vacancy(26, "Frontend Developer", "Bakı", "15 sen 2025"),
            Vacancy(27, "Backend Developer", "Sumqayıt", "20 sen 2025"),
            Vacancy(28, "DevOps mühəndisi", "Gəncə", "25 sen 2025"),
            Vacancy(29, "Layihə Meneceri", "Şəki", "01 okt 2025"),
            Vacancy(30, "Tərcüməçi", "Bakı", "10 okt 2025")
        )
    }
}