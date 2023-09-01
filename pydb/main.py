import csv
import psycopg2
from psycopg2 import sql

# Parâmetros de conexão com o PostgreSQL
db_params = {
    "dbname": "pydb",
    "user": "postgres",
    "password": "marcos",
    "host": "localhost",
    "port": "5432"  # Porta padrão do PostgreSQL
}

# Nome do arquivo CSV
csv_file = "data.csv"

# Função para conectar ao banco de dados e inserir os dados do CSV
def insert_data_from_csv():
    try:
        conn = psycopg2.connect(**db_params)
        cursor = conn.cursor()

        with open(csv_file, 'r') as file:
            reader = csv.DictReader(file)
            for row in reader:
                query = sql.SQL("INSERT INTO pessoa (id, nome) VALUES ({}, {})").format(
                    sql.Literal(row['id']),
                    sql.Literal(row['nome'])
                )
                cursor.execute(query)

        conn.commit()
        print("Dados inseridos com sucesso!")

    except psycopg2.Error as e:
        print("Erro ao inserir dados:", e)

    finally:
        if conn:
            conn.close()

if __name__ == "__main__":
    insert_data_from_csv()
