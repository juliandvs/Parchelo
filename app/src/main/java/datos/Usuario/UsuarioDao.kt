package datos.Usuario

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {

    /**
     * Inserta un usuario a la base de datos
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarUsuario(usuario: Usuario)

    /**
     * Buscamos y obtenemos un usuario a partir de su email y contraseña
     */
    @Query("SELECT * FROM Usuario WHERE email= :email and contrasena= :contrasena")
    suspend fun obtenerUsuario(email: String, contrasena: String): Usuario

    /**
     * Verificamos si existe un usuario a partir de un nombre de usuario en especifico
     */
    @Query("SELECT EXISTS (SELECT 1 FROM Usuario WHERE nombre_usuario = :nombreUsuario )")
    suspend fun verificarUsuario(nombreUsuario: String): Boolean

    /**
     * Verificamos si existe un email a partir de un email especifico
     */
    @Query("SELECT EXISTS (SELECT 1 FROM Usuario WHERE email = :email )")
    suspend fun verificarEmail(email: String): Boolean


}