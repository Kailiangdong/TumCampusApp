package de.tum.`in`.tumcampusapp.component.ui.chat.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import de.tum.`in`.tumcampusapp.component.tumui.lectures.model.LecturesSearchRow


@Entity(tableName = "chat_room", primaryKeys = arrayOf("name", "_id"))
data class ChatRoomDbRow(var room: Int = 0,
                         var name: String = "",
                         var semester: String = "",
                         @ColumnInfo(name = "semester_id")
                         var semesterId: String = "",
                         var joined: Int = 0,
                         @ColumnInfo(name = "_id")
                         var lvId: Int = 0,
                         var contributor: String = "",
                         var members: Int = -1,
                         @ColumnInfo(name = "last_read")
                         var lastRead: Int = -1) {


    companion object {
        fun fromLecture(lecture: LecturesSearchRow): ChatRoomDbRow {
            return ChatRoomDbRow(-1, lecture.titel, lecture.semester_name,
                    lecture.semester_id, -1,
                    lecture.stp_lv_nr.toInt(),
                    lecture.vortragende_mitwirkende, 0, -1)
        }
    }
}