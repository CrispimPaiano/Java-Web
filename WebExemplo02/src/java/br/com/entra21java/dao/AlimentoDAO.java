package br.com.entra21java.dao;


import br.com.entra21java.bean.AlimentoBean;
import br.com.entra21java.database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Crispim Paiano dos Santos
 */

public class AlimentoDAO {
    
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
    
    public int adicionar(AlimentoBean alimento){
        
        String sql = "INSERT INTO alimentos (nome, quantidade, preco, descricao) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++,alimento.getNome());
            ps.setByte(quantidade++, alimento.getQuantidade());
            ps.setDouble(quantidade++, alimento.getPreco());
            ps.setString(quantidade++, alimento.getDescricao());
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }return -1;
        
    }
    
    public boolean excluir(int id){
        String sql = "DELETE FROM alimentos WHERE id = ?";
        try {
            PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            Conexao.fecharConexao();
        }
        return false;
    }
    
    
    
}
