package com.example.almarket.data

import com.example.almarket.model.Notification

object FakeNotificationApi{
    suspend fun getNotifications(): List<Notification>{
        return listOf(
            Notification(1, "Yay! Endirim başladı", "Bütün məhsullarda 50%-dək endirim fürsətini qaçırmayın!", "12.05.2025"),
            Notification(2, "Yeni məhsullar stokda", "Yeni gələn məhsullar artıq satışdadır. Alış-verişə tələsin!", "13.05.2025"),
            Notification(3, "Xüsusi kampaniya", "Bu həftəyə özəl 1 alana 1 hədiyyə kampaniyamızla tanış olun!", "14.05.2025"),
            Notification(4, "Qapıya çatdırılma pulsuz", "Yalnız bu gün pulsuz çatdırılma fürsəti sizi gözləyir!", "15.05.2025"),
            Notification(5, "Ən çox satılanlar", "Ən çox seçilən məhsulları endirimli qiymətlərlə əldə edin!", "16.05.2025"),
            Notification(6, "Kartla ödə, bonus qazan", "Kartla etdiyin hər ödənişə 5% bonus qazandırırıq!", "17.05.2025"),
            Notification(7, "Sadiqlik proqramı başladı", "Yeni müştəri proqramımızla daha çox endirim və hədiyyə qazanın!", "18.05.2025"),
            Notification(8, "Səhər endirimləri", "Saat 9:00-dan 12:00-a qədər alış-verişə 15% endirim!", "19.05.2025"),
            Notification(9, "Yeni filialımız açıldı", "Yeni Sumqayıt filialımıza gələrək sürpriz endirimlərdən faydalanın!", "20.05.2025"),
            Notification(10, "Ət məhsullarında endirim", "Bu həftə bütün ət məhsullarında 20%-ə qədər endirim var!", "21.05.2025"),
            Notification(11, "Meyvə-tərəvəz aksiyası", "Təzə meyvə və tərəvəzləri daha sərfəli qiymətlərlə alın!", "22.05.2025"),
            Notification(12, "Bayram kampaniyası", "Bayrama özəl aksiyalarla alış-veriş daha sərfəlidir!", "23.05.2025"),
            Notification(13, "Al-ver et, hədiyyə qazan", "Minimum 30 AZN-lik alışa sürpriz hədiyyə sizi gözləyir!", "24.05.2025"),
            Notification(14, "Sürətli çatdırılma xidməti", "Yeni çatdırılma xidmətimizlə 1 saatda qapınızdayıq!", "25.05.2025"),
            Notification(15, "Aylıq endirim siyahısı", "May ayı üzrə endirimli məhsullar artıq siyahıda!", "26.05.2025"),
            Notification(16, "Qəhvə sevənlərə özəl", "Bütün qəhvə növlərində bu həftə 10% endirim!", "27.05.2025"),
            Notification(17, "Səhər alış-verişinə hədiyyə", "Səhər saatlarında alın, pulsuz məhsullar qazanın!", "28.05.2025"),
            Notification(18, "Qadınlar üçün kampaniya", "Qadın baxım məhsullarında super endirimlər sizi gözləyir!", "29.05.2025"),
            Notification(19, "Təmizlik məhsulları ucuzlaşdı", "Ən çox istifadə edilən təmizlik məhsulları indi daha ucuz!", "30.05.2025"),
            Notification(20, "Xüsusi endirim kodu", "Yalnız mobil tətbiq istifadəçilərinə özəl ENDIRIM10 kodu!", "31.05.2025"),
            Notification(21, "İsti günlərə sərin fürsət", "Dondurma və içkilərdə xüsusi yay endirimi başladı!", "01.06.2025"),
            Notification(22, "Hər gün yeni endirim", "Hər gün fərqli məhsullarda endirim fürsətini qaçırmayın!", "02.06.2025"),
            Notification(23, "Səbətinə əlavə et, qazan", "3 məhsul alana 1 məhsul hədiyyə!", "03.06.2025"),
            Notification(24, "Uşaqlar üçün məhsullar", "Uşaq qidalarında və oyuncaqlarda endirimlər başladı!", "04.06.2025"),
            Notification(25, "Online ödə, 5% qazanc", "Online ödənişlə alış-veriş edin və 5% geri qazanın!", "05.06.2025"),
            Notification(26, "Məhdud sayda məhsul", "Məhdud sayda olan məhsullar stokda! Tələsin!", "06.06.2025"),
            Notification(27, "Dəftərxana məhsulları", "Qələm, dəftər və digər ofis məhsullarında kampaniya!", "07.06.2025"),
            Notification(28, "Ev üçün endirimli seçimlər", "Ev məhsullarını endirimli qiymətlərlə əldə edin!", "08.06.2025"),
            Notification(29, "Sağlam qida aksiyası", "Fit qalmaq istəyənlərə özəl sağlam məhsullarda endirim!", "09.06.2025"),
            Notification(30, "Bonus balansınızı yoxlayın", "Topladığınız bonusları indi istifadə etmə zamanı!", "10.06.2025")        )
    }
}