package todo.web;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import todo.dao.TodoDAO;
import todo.dto.Todo;
 
/**
 * �����@�\�B�^�X�N�ꗗ���擾���A�ꗗ���ʂփt�H���[�h����B
 */
@WebServlet(urlPatterns = { "/todo/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		// DAO�̎擾
		try (TodoDAO dao = new TodoDAO()) {
			// �^�X�N�̃��X�g���ꗗ�Ŏ擾���A���N�G�X�g�����֊i�[����
			List<Todo> list = dao.todoList();
 
			request.setAttribute("todoList", list);
		} catch (Exception e) {
			throw new ServletException(e);
		}
 
		// �����ꗗ��\������
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);
	}
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
