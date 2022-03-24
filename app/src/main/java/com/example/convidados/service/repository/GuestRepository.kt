package com.example.convidados.service.repository

import android.content.Context
import com.example.convidados.service.model.GuestModel

class GuestRepository (context: Context) {

    //private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    private val mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    //Singleton
    /*companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }*/

    fun get(id: Int): GuestModel {

        return mDataBase.get(id)
        /*var guest: GuestModel? = null

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                selection,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()

                val name =
                    cursor.getStringOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                //Tratando o valor para retornar um boolean
                val presence =
                    (cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)

                guest = GuestModel(id, name!!, presence)
            }
            cursor?.close()
            guest
        } catch (e: Exception) {
            guest
        }*/
    }

    fun getAll(): List<GuestModel> {

        return mDataBase.getInvited()
        /*val list: MutableList<GuestModel> = ArrayList()

        return try {
            val db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                //enquanto tiver um proximo valor no cursor, ele vai retorna verdadeiro e continuar ata retornar falso
                while (cursor.moveToNext()) {

                    val id =
                        cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getStringOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        (cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)
                    //tratei de forma diferente o ID, pois ele nunca vai ser nulo por causa do autoincrement do banco de dados
                    val guest = GuestModel(id!!, name!!, presence)
                    list.add(guest)
                }
                cursor.moveToFirst()
            }
            cursor?.close()
            list
        } catch (e: Exception) {
            list
        }*/
    }

    fun getPresent(): List<GuestModel> {

        return mDataBase.getPresent()
        /*val list: MutableList<GuestModel> = ArrayList()
        return try {
            val db = mGuestDataBaseHelper.readableDatabase
            //Atencao ao usar o rawQuery e escrever o SQL direto
            val cursor = db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 1", null)

            if (cursor != null && cursor.count > 0) {
                //enquanto tiver um proximo valor no cursor, ele vai retorna verdadeiro e continuar ata retornar falso
                while (cursor.moveToNext()) {

                    val id =
                        cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getStringOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        (cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)
                    //tratei de forma diferente o ID, pois ele nunca vai ser nulo por causa do autoincrement do banco de dados
                    val guest = GuestModel(id!!, name!!, presence)
                    list.add(guest)
                }
                cursor.moveToFirst()
            }
            cursor?.close()
            list
        } catch (e: Exception) {
            list
        }*/
    }

    fun getAbsent(): List<GuestModel> {

        return mDataBase.getAbsent()
        /*val list: MutableList<GuestModel> = ArrayList()
        return try {
            val db = mGuestDataBaseHelper.readableDatabase
            //Atencao ao usar o rawQuery e escrever o SQL direto
            val cursor = db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 0", null)

            if (cursor != null && cursor.count > 0) {
                //enquanto tiver um proximo valor no cursor, ele vai retorna verdadeiro e continuar ata retornar falso
                while (cursor.moveToNext()) {

                    val id =
                        cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getStringOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        (cursor.getIntOrNull(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE)) == 1)
                    //tratei de forma diferente o ID, pois ele nunca vai ser nulo por causa do autoincrement do banco de dados
                    val guest = GuestModel(id!!, name!!, presence)
                    list.add(guest)
                }
                cursor.moveToFirst()
            }
            cursor?.close()
            list
        } catch (e: Exception) {
            list
        }*/
    }

    fun save(guest: GuestModel): Boolean {

        return mDataBase.save(guest) > 0 //verificacao para retornar booleano
        /*return try {
            val db = mGuestDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        } catch (e: Exception) {
            false
        }*/
    }

    fun update(guest: GuestModel): Boolean {

        return mDataBase.update(guest) > 0
        /*return try {
            val db = mGuestDataBaseHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)
            //criteria para atualizacao
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)
            true
        } catch (e: Exception) {
            false
        }*/
    }

    fun delete(guest: GuestModel) {

        mDataBase.delete(guest)
        /*return try {
            val db = mGuestDataBaseHelper.writableDatabase

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }*/
    }
}