package com.example.a2dfarming.ui.pages

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.a2dfarming.R
import com.example.a2dfarming.ui.composables.Conversation
import com.example.a2dfarming.ui.pages.navigation.Routes
import com.example.a2dfarming.viewModels.GameVM
import com.example.a2dfarming.viewModels.SoundManager

@Composable
fun Conversations(
    navController: NavHostController,
    gameVM: GameVM,
    soundVM: SoundManager,
) {
    // data
    var characterName by rememberSaveable { mutableStateOf("You shouldn't be here") }
    var textValue by rememberSaveable { mutableStateOf("You shouldn't be here") }
    var isPlayer by rememberSaveable { mutableStateOf(true) }
    var buttonText by rememberSaveable { mutableStateOf("...") }
    var imageRes by rememberSaveable { mutableIntStateOf(R.drawable.duy) }


    // miscellaneous
    val context = LocalContext.current
    val activity = context as? Activity


    // Cutscene handler
    fun cutsceneHandler() {
        gameVM.cutsceneNum += 1

        if (gameVM.cutsceneNum == 1) {
            characterName = "Cốt truyện"
            textValue = "Trong 1 buổi nhậu , bạn uống 5 lon bia trong 1 quãng thời gian ngắn\n\nsau đó bạn cảm thấy người say như điếu đổ, bạn ngồi đó, từ từ khép 2 đôi mắt nặng trĩu của bạn lại..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.nhau

        } else if (gameVM.cutsceneNum == 2) {
            characterName = "..."
            textValue = "zzz"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 3) {
            characterName = "..."
            textValue = "zzzzzzzzzzzzzzzzzzzzzzzz"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 4) {
            characterName = "..."
            textValue = "zzzzz"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 5) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "BÙM"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

            // play track_introduction
            soundVM.playTrack(R.raw.track_introduction)

        } else if (gameVM.cutsceneNum == 6) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "Bạn tỉnh giấc!"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 7) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "Chà ngươi đã tỉnh dậy rồi sao!."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 8) {
            characterName = "Bạn"
            textValue = "Ngươi, NGƯƠI LÀ AI!"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 9) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "Ta là ai không quan trọng, điều quan trọng ở đây là NGƯƠI, mắc nợ ta 9 kiếp rồi mà chưa chịu trả"
            isPlayer = true
            buttonText = "hả"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 10) {
            characterName = "Bạn"
            textValue = "hả?"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 11) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "mà điều đó hiện tại không quan trọng, bây giờ ta sẽ cho ngươi 10$, đô la USA xịn xò con bò luôn!"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 12) {
            characterName = "Bạn"
            textValue = "Thiệt không?"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 13) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "Thiệt, đổi lại ngươi sẽ nợ ta 10000$ !!!"
            isPlayer = true
            buttonText = "NANIIIIIII"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 14) {
            characterName = "Bạn"
            textValue = "NANI !!!?"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

            // stop track_introduction
            soundVM.stopTrack()

        } else if (gameVM.cutsceneNum == 15) {
            characterName = "NGƯỜI BÍ ẨN ???"
            textValue = "Được rồi, bây giờ hãy ĐI RA NGOÀI ĐỒNG VÀ LÀM VIỆC CHO TA, ta ngồi chờ ở trong này, ta giao nhiệm vụ cho ngươi là kiếm 10000$ và trả lại cho ta :D"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

            // play track_farm
            soundVM.playTrack(R.raw.track_farm)

        } else if (gameVM.cutsceneNum == 16) {

            navController.navigate(Routes.A2DFarming)


        // Neutral ending (cutsceneNum == 19).
        } else if (gameVM.cutsceneNum == 20) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "chà hãy nhìn vào ngươi xem..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

            // Stop track_farm
            soundVM.stopTrack()

            // Play track_win
            soundVM.playTrack(R.raw.track_win)

        } else if (gameVM.cutsceneNum == 21) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 22) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "Nhà người còn chờ gì nữa?, mau đưa cho ta, cái túi đó, TÚI CHỨA TIỀN !!!"
            isPlayer = true
            buttonText = "Đưa túi tiền"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 23) {
            characterName = "Cốt truyện"
            textValue = "(bạn đưa túi tiền chứa nhiều hơn 10000$ cho người bí ẩn...)"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.cat_take_money

        } else if (gameVM.cutsceneNum == 24) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 25) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "......."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 26) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "E Hèm, được rồi..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 27) {
            characterName = "Cốt truyện"
            textValue = "(Người bí ẩn dần dần lộ diện...)"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer_reveal

        } else if (gameVM.cutsceneNum == 28) {
            characterName = "MÈO CON !!!"
            textValue = "MÈO CON!??"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 29) {
            characterName = "MÈO CON !!!"
            textValue = "Nhà ngươi có thể đi..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 30) {
            characterName = "MÈO CON !!!"
            textValue = "Mặc dầu..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 31) {
            characterName = "MÈO CON !!!"
            textValue = "..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 32) {
            characterName = "MÈO CON !!!"
            textValue = "Ta đã hi vọng ngươi là người có khả năng sẽ đạt tới hạt giống \"???\" thứ 15 đấy cơ"
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 33) {
            characterName = "MÈO CON !!!"
            textValue = "..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 34) {
            characterName = "MÈO CON !!!"
            textValue = "TA CUỐI CÙNG CŨNG CÓ TIỀN ĐI ĐÁNH BI-DA RỒI, CẢM ƠN NHÀ NGƯƠI NHIỀU !!!"
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.cat2

        } else if (gameVM.cutsceneNum == 35) {
            characterName = "CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG GAME"
            textValue = "(Mèo con chạy mất tiêu...)"
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 36) {
            characterName = "CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG GAME"
            textValue = "chạy mất tiêu..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 37) {
            characterName = "CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG GAME"
            textValue = "mất tiêu..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 38) {
            characterName = "CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG GAME"
            textValue = "tiêu..."
            isPlayer = true
            buttonText = ":3"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 39) {
            characterName = "CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG GAME"
            textValue = "..."
            isPlayer = true
            buttonText = "."
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 40) {
            characterName = "CHÚC MỪNG BẠN ĐÃ CHIẾN THẮNG GAME"
            textValue = "..."
            isPlayer = true
            buttonText = ""
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 41) {
            characterName = "Credits"
            textValue = "Side Kotlin project được code bởi: Boima. một bản làm lại game 2D farming từ Java.\n\nVới sự 'góp mặt' của anh bạn Duy"
            isPlayer = true
            buttonText = "Kết thúc game."
            imageRes = R.drawable.white

            // Stop track_win
            soundVM.stopTrack()


        // Truth ending (cutsceneNum == 99).
        } else if (gameVM.cutsceneNum == 100) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "chà hãy nhìn vào ngươi xem..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

            // Stop track_farm
            soundVM.stopTrack()

            // Play farewell
            soundVM.playTrack(R.raw.farewell)

        } else if (gameVM.cutsceneNum == 101) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 102) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "Nhà người còn chờ gì nữa?, mau đưa cho ta, cái túi đó, TÚI CHỨA TIỀN !!!"
            isPlayer = true
            buttonText = "Đưa túi tiền"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 103) {
            characterName = "Cốt truyện"
            textValue = "(bạn đưa túi tiền chứa nhiều hơn 10000$ cho người bí ẩn...)"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.cat_take_money

        } else if (gameVM.cutsceneNum == 104) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 105) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 106) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 107) {
            characterName = "NGƯỜI BÍ ẨN"
            textValue = "E Hèm, được rồi..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer

        } else if (gameVM.cutsceneNum == 108) {
            characterName = "Cốt truyện"
            textValue = "(Người bí ẩn dần dần lộ diện...)"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.thedealer_reveal

        } else if (gameVM.cutsceneNum == 109) {
            characterName = "MỘT CON MÈO ?!!"
            textValue = "MỘT CON MÈO !??"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 110) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 111) {
            characterName = "CON MÈO"
            textValue = "đúng vậy, ta..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 112) {
            characterName = "CON MÈO"
            textValue = "là một con mèo"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 113) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 114) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 115) {
            characterName = "CON MÈO"
            textValue = "ngươi làm tốt lắm"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 116) {
            characterName = "CON MÈO"
            textValue = "với chừng này số tiền, từ giờ đến cuối đời ta không cần phải lo về vấn đề tiền bạc nữa"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 117) {
            characterName = "CON MÈO"
            textValue = "ta có thể uống bia tùy thích, TA CÓ THỂ ĐI ĐÁNH BI DA TÙY THÍCH"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 118) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 119) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 120) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 121) {
            characterName = "CON MÈO"
            textValue = "ngươi có thể đi được rồi."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 122) {
            characterName = "CON MÈO"
            textValue = "phía đằng sau ngươi, đi lên 10 nấc thang"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 123) {
            characterName = "CON MÈO"
            textValue = "ngươi sẽ tỉnh dậy"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 124) {
            characterName = "CON MÈO"
            textValue = "còn ta?"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 125) {
            characterName = "CON MÈO"
            textValue = "ta sẽ ở lại đây"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 126) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 127) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 128) {
            characterName = "CON MÈO"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 129) {
            characterName = "CON MÈO"
            textValue = "nhà ngươi còn chần chờ gì nữa?"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.cat1

        } else if (gameVM.cutsceneNum == 130) {
            characterName = "CON MÈO"
            textValue = "ĐI ĐI"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.sadcat

        } else if (gameVM.cutsceneNum == 131) {
            characterName = "con mèo đang khóc?"
            textValue = "ta không muốn buồn vì những kí ức đau buồn nữa"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.sadcat

        } else if (gameVM.cutsceneNum == 132) {
            characterName = "con mèo đang khóc?"
            textValue = "giống như cách chúng bỏ rơi ta, sẵn sàng cắt bỏ ta ngay khi ta không còn hữu dụng"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.sadcat

        } else if (gameVM.cutsceneNum == 133) {
            characterName = "con mèo đang khóc"
            textValue = "ta cũng không cần ngươi sau khi ngươi xong việc"
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.sadcat

        } else if (gameVM.cutsceneNum == 134) {
            characterName = "con mèo đang khóc"
            textValue = "..."
            isPlayer = true
            buttonText = "Tiếp tục"
            imageRes = R.drawable.sadcat

        } else if (gameVM.cutsceneNum == 135) {
            characterName = "con mèo đang khóc"
            textValue = "..."
            isPlayer = true
            buttonText = "Quay lưng rời đi"
            imageRes = R.drawable.sadcat

        } else if (gameVM.cutsceneNum == 136) {
            characterName = "Cốt truyện"
            textValue = "(bạn quay lưng rời đi, còn 10 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 137) {
            characterName = "Cốt truyện"
            textValue = "(còn 9 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 138) {
            characterName = "Cốt truyện"
            textValue = "(còn 8 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 139) {
            characterName = "Cốt truyện"
            textValue = "(còn 7 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 140) {
            characterName = "Cốt truyện"
            textValue = "(còn 6 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 141) {
            characterName = "Cốt truyện"
            textValue = "(còn 5 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 142) {
            characterName = "Chú mèo"
            textValue = "Mạnh khỏe"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 143) {
            characterName = "Cốt truyện"
            textValue = "(còn 3 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 144) {
            characterName = "Cốt truyện"
            textValue = "(còn 2 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 145) {
            characterName = "Cốt truyện"
            textValue = "(còn 1 nấc thang nữa)"
            isPlayer = true
            buttonText = "Đi tiếp"
            imageRes = R.drawable.staircase

        } else if (gameVM.cutsceneNum == 146) {
            characterName = "Cốt truyện"
            textValue = "(bạn rời đi)"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 147) {
            characterName = "Cốt truyện"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 148) {
            characterName = "Cốt truyện"
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 149) {
            characterName = ""
            textValue = "..."
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 150) {
            characterName = ""
            textValue = "(bạn chập chừng tỉnh dậy)"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.after_party_reveal

        } else if (gameVM.cutsceneNum == 151) {
            characterName = "Cốt truyện"
            textValue = "(tỉnh dậy, bạn thấy mình vẫn còn đang còn ở bàn nhậu, xung quanh không còn ai cả, có vẻ mọi người đã về hết)"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.after_party

        } else if (gameVM.cutsceneNum == 152) {
            characterName = "Cốt truyện"
            textValue = "(bạn ngồi đó, trầm tư suy nghĩ)"
            isPlayer = true
            buttonText = "..."
            imageRes = R.drawable.after_party

        } else if (gameVM.cutsceneNum == 153) {
            characterName = "Bạn"
            textValue = "một giấc mơ thật kì lạ."
            isPlayer = true
            buttonText = "Credits"
            imageRes = R.drawable.white

        } else if (gameVM.cutsceneNum == 154) {
            characterName = "Credits"
            textValue = "Side Kotlin project được code bởi: Boima. một bản làm lại game 2D farming từ Java.\n\nVới sự 'góp mặt' của anh bạn Duy"
            isPlayer = true
            buttonText = "Kết thúc game."
            imageRes = R.drawable.white

            // Stop farewell
            soundVM.stopTrack()

        } else {
            // exit from app
            activity?.finish()
        }
    }


    LaunchedEffect(Unit) {
        cutsceneHandler()
    }


    Conversation(
        imageRes = imageRes,
        characterName = characterName,
        textValue = textValue,
        isPlayer = isPlayer,
        buttonText = buttonText,
        onButtonClick = { cutsceneHandler() }
    )
}