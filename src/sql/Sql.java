package sql;
/*
 * 
 * 2016_12_08
 * 
 * ����Ŭ �⺻ ��Ʈ : 1521
 * NOT NULL : ���� �׻� ���� �Ѵ�.
 * 
 * ��1����ȭ : �����Ϳ� ������ ���� �ʵ���.
 * ��2����ȭ : �ߺ��� �����Ͱ� ��������� �ʵ���.
 * 
 * select * from tab; -> �ش� �����ͺ��̽��� ��� ���̺� ��ȸ.
 * desc ���̺�� -> ���̺��� ������ ��ȸ.
 * 
 * ����Ŭ�� ������ ��
 *  1. NUMBER ������ �� 
 *    NUMBER(precision, scale) -> scale : �Ҽ��� �ڸ� ��
 *  
 *  2. VARCHAR2 ������ ��
 *    ���� ���ڿ� ������ ��
 *     - �����ڴ� �ѱ��ڿ� �Ѱ����� ����
 *     - �ѱ��ڴ� �ѱ��ڿ� �������� ����
 *    
 *  3. DATE ������ ��
 *    ��¥�� ǥ���ϴ� ������ ��
 * 
 * SELECT ��
 *  SELECT [DISTINCT] �÷�, ... FROM ���̺� ��;
 *   
 *   *NULL �� ������ �̴�.
 *    1. 0(zero)�� �ƴϰ�
 *    2. �� ������ �ƴϴ�
 *    3. ��Ȯ��(�ش� ���� ����), �� �� ����(unknown) ���� �ǹ��Ѵ�.
 *    4. � ������ �� �� ������ � ���� �����ϰ� �ִ�.
 *    5. ? Ȥ�� ���Ѵ� �� �ǹ� �̹Ƿ�
 *    6. ����, �Ҵ�, �񱳰� �Ұ��� �ϴ�.
 *    
 * ��Ī
 *  [1] �빮�� �ҹ��ڸ� ���������� ����� ��ҹ��� �������� �ʰ� ���.
 *  SQL > SELECT ename, sal*12+comm Annsal FROM emp;
 *  
 *  [2] ""���̿��� ���鹮��, _, # ��� �����ϸ� ��ҹ��ڰ� ���еǾ� ���.
 *  SQL > SELECT ename, sal*12+comm "A n n s a l" FROM emp;
 *  
 *  [3] �ѱ� ����� �����ϴ�.
 *  SQL > SELECT ename, sal*12+comm "����" FROM emp;
 *  
 *  [4] AS�� ����Ͽ� ��Ī�� �ο��ϴ� ���.
 *  SQL > SELECT ename, sal*12+comm AS Annsal FROM emp;
 *  
 *    * "" -> ��Ī���� �����ϰ� ���.
 *  	'' -> ���ڿ� ǥ���ϴµ� ���.
 *  	
 * Concatenation ( || ) �������� ���ǿ� ���
 *  �÷��� �÷��� ������.
 *  SQL > SELECT ename, 'is a', job FROM emp;
 *  SQL > SELECT enmae || 'is a' || job FROM emp;
 *  
 * DISTINCT Ű����
 *  �ߺ��Ǵ� �����͸� �ѹ��� ������.
 *  SQL > SELECT DISTINCT deptno FROM emp;
 *  
 * WHERE ��
 *  Ư�� �����͸� �����ϱ� ���� ������ ���
 *  SQL > SELECT columns FROM table_name WHERE conditions;
 *  
 *  ex) �μ���ȣ�� 10���� ����� ���� ����
 *   SQL > SELECT * FROM emp WHERE deptno = 10;
 *  ex) �޿��� 2000�̻� �Ǵ� ����� �����ȣ, ����̸�, �޿��� ���
 *   SQL > SELECT * FROM emp WHERE sal >= 2000;
 *  ex) �̸��� FORD �� ����� �����ȣ, ����̸��� ���
 *   SQL > SELECT empno, ename FROM emp WHERE ename = 'FORD';
 *     * ������ ��
 *      -> ���� ����ǥ �ȿ� ���ڿ� �����ʹ� ��ҹ��ڸ� �����ϹǷ� �ҹ��ڷ�
 *         ������� ����ϸ� �ش� �����͸� ã�� ���մϴ�.
 * 
 * �� ������
 *  AND - �� ���� ������ ��� �����ؾ߸� �˻��� �� �ִ�.
 *   ex) �μ���ȣ�� 10�̸鼭 ������ CLERK �� ����� ���.
 *   SQL > SELECT * FROM emp WHERE deptno = 10 AND job = 'CLERK';
 *  OR - �� ���� ���� �߿��� �Ѱ����� �����ϴ��� �˻��� �� �ִ�.
 *   ex) �Ի�⵵�� 1982�� 01�� 01�� ���� �̰ų� ������ MANAGER �� ����� ���.
 *   SQL > SELECT * FROM emp WHERE hiredate >= '1982/01/01' OR job = 'MANAGER';
 *  NOT - ���ǿ� �������� ���ϴ� �͸� �˻��Ѵ�.
 *   ex) �μ���ȣ�� 10���� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE NOT deptno = 10;
 *   SQL > SELECT * FROM emp WHERE deptno <> 10;
 *   ex) �޿��� 2000 ���� 3000 ���̰� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE sal NOT BETWEEN 2000 AND 3000;
 *   ex) Ŀ�̼��� 300�̰ų� 500�̰ų� 1400�� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE comm NOT IN(300, 500, 1400);
 *   ex) �̸��� A�� ���� �ʴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE ename NOT LIKE '%A%';
 *  IS - NULL �� ���� �Ǻ�
 *   ex) Ŀ�̼��� ���� null �� ����� ���.
 *   SQL > SELECT * FROM emp WHERE comm IS NULL;
 *   ex) Ŀ�̼��� ���� null �� �ƴ� ����� ���.
 *   SQL > SELECT * FROM emp WHERE comm IS NOT NULL;
 * 
 * LIKE ( ���� ó�� ������ )
 *  [����] Column_name like 'pattern'
 *  ex) ��� �̸��� J�� �����ϴ� ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE 'J%';
 *  ex) ��� �̸��� N���� ������ ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE '%N';
 *  ex) ��� �̸��� A�� ���� ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE '%A%';
 *  ex) ��� �̸��� �ι�° ��¥�� A�� ����� ���
 *  SQL > SELECT * FROM emp WHERE ename LIKE '_A%';
 *  
 *  
 * IN ������
 *  [����] �÷� in(��ȸ ����..)
 *  ex) Ŀ�̼��� 300 �Ǵ� 500 �Ǵ� 1400 �� ����� ���
 *  SQL> SELECT * FROM emp WHERE comm = 300 OR comm = 500 OR comm = 1400;
 *  SQL> SELECT * FROM emp WHERE comm IN(300, 500, 1400);
 * 
 * BETWEEN AND ������
 * 
 *  [����] �÷� BETWEEN ���� AND ��
 *  ex) �޿��� 2000 ���� 3000 ������ ����� ���
 *  SQL> SELECT * FROM emp WHERE sal >= 2000 AND sal <= 3000;
 *  SQL> SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;
 *  
 * ORDER BY ( �����Ͽ� ��� )
 *  [����] ORDER BY �÷Ÿ� [ASC | DESC]
 *  ex) �޿������� �������� ������ ����� ������ ���.
 *  SQL > SELECT * FROM emp ORDER BY sal;
 *  SQL > SELECT * FROM emp ORDER BY sal ASC;
 *  ex) �޿������� �������� ������ ����� ������ ���.
 *  SQL > SELECT * FROM emp ORDER BY sal DESC;
 *  ex) �μ���ȣ�� �������� �����ϰ� �޿������� �������� ������ ����� ������ ���.
 *  SQL > SELECT * FROM emp ORDER BY deptno ASC, sal DESC;
 *   
 */
public class Sql {

}
