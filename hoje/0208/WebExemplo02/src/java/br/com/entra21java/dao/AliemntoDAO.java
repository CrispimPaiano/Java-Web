package br.com.entra21java.dao;

import br.com.entra21java.bean.AlimentoBean;
import br.com.entra21java.database.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */

public class AliemntoDAO {
    
    public List<AlimentoBean> obterTodos(){
        
        List<AlimentoBean> alimentos = new ArrayList<>();
        String sql = "SELECT * FROM alimentos";
        try {
            Statement st = Conexao.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultset = st.getResultSet();
            while (resultset.next()) {
                AlimentoBean alimento = new AlimentoBean();
                alimento.setId(resultset.getInt("id"));
                alimento.setNome(resultset.getString("nome"));
                alimento.setPreco(resultset.getDouble("preco"));
                alimento.setQuantidade(resultset.getByte("quantidade"));
                alimentos.add(alimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
        return alimentos;
    }
}
