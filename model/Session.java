package model;
import model.entities.Usuario;
public class Session {
    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static void logout() {
        usuarioLogado = null;
    }

    public static boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }
}
