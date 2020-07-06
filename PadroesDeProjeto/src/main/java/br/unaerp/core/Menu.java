package br.unaerp.core;

import br.unaerp.dto.CategoriesDTO;
import br.unaerp.dto.ProductsDTO;
import br.unaerp.dto.SuppliersDTO;
import br.unaerp.entity.Categories;
import br.unaerp.entity.Products;
import br.unaerp.entity.Suppliers;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void OpenMenu() {
        System.out.println("****************");
        System.out.println("1. Inserir nova categoria");
        System.out.println("2. Inserir novo produto");
        System.out.println("3. Inserir novo Fornecedor");
        System.out.println("4. Exibir todas categorias");
        System.out.println("5. Exibir todos produtos");
        System.out.println("6. Exibir todos fornecedores");
        System.out.println("7. Excluir Categoria");
        System.out.println("8. Excluir Produto");
        System.out.println("9. Excluir Fornecedor");
        System.out.println("10. Exibir categoria detalahada");
        System.out.println("11. Exibir produto detalahado");
        System.out.println("12. Exibir fornecedor detalahado");
        System.out.println("****************");

        switch (new Scanner(System.in).nextInt()) {
            case 1:
                insertCategorie();
                break;
            case 2:
                insertProduct();
                break;
            case 3:
                insertSupplier();
                break;
            case 4:
                showCategories();
                break;
            case 5:
                showProducts();
                break;
            case 6:
                showSuppliers();
                break;
            case 7:
                deleteCategorie();
                break;
            case 8:
                deleteProduct();
                break;
            case 9:
                deleteSupplier();
                break;
            case 10:
                showCategorie();
                break;
            case 11:
                showProduct();
                break;
            case 12:
                showSupplier();
                break;
            default:
                System.out.println("Tente novamente!");
                OpenMenu();
        }
    }

    private void insertCategorie() {
        System.out.println("Category name: ");
        String name = new Scanner(System.in).next();
        System.out.println("Descricao: ");
        String desc = new Scanner(System.in).next();
        System.out.println("Picture: ");
        String pic = new Scanner(System.in).next();

        Categories obj = new Categories(name, desc, pic);
        CategoriesDTO dtoObj = new CategoriesDTO(obj.getCategoryName(), obj.getDescription(), obj.getPicture());

        CategoryBO bo = new CategoryBO(selectDB());

        try {
            bo.insert(dtoObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void insertProduct() {
        System.out.println("Name: ");
        String name = new Scanner(System.in).next();
        System.out.println("Supplier id: ");
        int supplierId = new Scanner(System.in).nextInt();
        System.out.println("Category id: ");
        int categoryId = new Scanner(System.in).nextInt();
        System.out.println("quantityPerUnit: ");
        int quantityPerUnit = new Scanner(System.in).nextInt();
        System.out.println("unitPrice: ");
        double unitPrice = new Scanner(System.in).nextDouble();
        System.out.println("unitsInStock: ");
        int unitsInStock = new Scanner(System.in).nextInt();
        System.out.println("unitsOnOrder: ");
        int unitsOnOrder = new Scanner(System.in).nextInt();
        System.out.println("reorderLevel: ");
        int reorderLevel = new Scanner(System.in).nextInt();
        System.out.println("discontinued: ");
        int discontinued = new Scanner(System.in).nextInt();

        ProductsDTO productsDTO = new ProductsDTO(name, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);


        ProductBO bo = new ProductBO(selectDB());

        try {
            bo.insert(new ProductsDTO(
                    productsDTO.getProductName()
                    , productsDTO.getSupplierId()
                    , productsDTO.getCategoryId()
                    , productsDTO.getQuantityPerUnit()
                    , productsDTO.getUnitPrice()
                    , productsDTO.getUnitsInStock()
                    , productsDTO.getUnitsOnOrder()
                    , productsDTO.getReorderLevel()
                    , productsDTO.getDiscontinued()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertSupplier() {
        System.out.println("Company Name: ");
        String compName = new Scanner(System.in).next();
        System.out.println("Contact Name: ");
        String contaName = new Scanner(System.in).next();
        System.out.println("Contact Title: ");
        String contaTitle = new Scanner(System.in).next();
        System.out.println("Address: ");
        String address = new Scanner(System.in).next();
        System.out.println("City: ");
        String city = new Scanner(System.in).next();
        System.out.println("Region: ");
        String region = new Scanner(System.in).next();
        System.out.println("Postal Code: ");
        String postalCode = new Scanner(System.in).next();
        System.out.println("country: ");
        String country = new Scanner(System.in).next();
        System.out.println("Phone: ");
        String phone = new Scanner(System.in).next();
        System.out.println("Fax: ");
        String fax = new Scanner(System.in).next();
        System.out.println("HomePage: ");
        String homepage = new Scanner(System.in).next();


        Suppliers suppliers = new Suppliers(compName, contaName, contaTitle, address, city, region, postalCode, country, phone, fax, homepage);

        SuppliersDTO suppliersDTO =
                new SuppliersDTO(suppliers.getCompanyName()
                        , suppliers.getContactName()
                        , suppliers.getContactTitle()
                        , suppliers.getAddress()
                        , suppliers.getCity()
                        , suppliers.getRegion()
                        , suppliers.getPostalCode()
                        , suppliers.getCountry()
                        , suppliers.getPhone()
                        , suppliers.getFax()
                        , suppliers.getHomePage());

        SuppliersBO bo = new SuppliersBO(selectDB());

        try {
            bo.insert(suppliersDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCategories() {
        CategoryBO bo = new CategoryBO(selectDB());
        List<Categories> categoriesList = null;
        try {
            categoriesList = bo.getCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Categories categories : categoriesList) {
            System.out.println(categories.toString());
        }
    }

    private void showProducts() {
        ProductBO bo = new ProductBO(selectDB());
        List<Products> productsList = null;
        try {
            productsList = bo.getProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Products products : productsList) {
            System.out.println(products.toString());
        }
    }

    private void showSuppliers() {
        SuppliersBO bo = new SuppliersBO(selectDB());
        List<Suppliers> suppliersList = null;
        try {
            suppliersList = bo.getSuppliers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Suppliers sup : suppliersList) {
            System.out.println(sup.toString());
        }
    }

    private void deleteCategorie() {
        System.out.println("Informe o id");
        int id = new Scanner(System.in).nextInt();
        CategoryBO categoryBO = new CategoryBO(selectDB());
        try {
            categoryBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct() {
        System.out.println("Informe o id");
        int id = new Scanner(System.in).nextInt();
        ProductBO categoryBO = new ProductBO(selectDB());
        try {
            categoryBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteSupplier() {
        System.out.println("Informe o id");
        int id = new Scanner(System.in).nextInt();
        SuppliersBO categoryBO = new SuppliersBO(selectDB());
        try {
            categoryBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCategorie() {
        System.out.println("ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Category name: ");
        String name = new Scanner(System.in).next();
        System.out.println("Descricao: ");
        String desc = new Scanner(System.in).next();
        System.out.println("Picture: ");
        String pic = new Scanner(System.in).next();

        Categories obj = new Categories(id, name, desc, pic);
        CategoriesDTO dtoObj = new CategoriesDTO(obj.getCategoryId(), obj.getCategoryName(), obj.getDescription(), obj.getPicture());

        CategoryBO bo = new CategoryBO(selectDB());

        try {
            bo.update(dtoObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct() {
        System.out.println("ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Name: ");
        String name = new Scanner(System.in).next();
        System.out.println("Supplier id: ");
        int supplierId = new Scanner(System.in).nextInt();
        System.out.println("Category id: ");
        int categoryId = new Scanner(System.in).nextInt();
        System.out.println("quantityPerUnit: ");
        int quantityPerUnit = new Scanner(System.in).nextInt();
        System.out.println("unitPrice: ");
        double unitPrice = new Scanner(System.in).nextDouble();
        System.out.println("unitsInStock: ");
        int unitsInStock = new Scanner(System.in).nextInt();
        System.out.println("unitsOnOrder: ");
        int unitsOnOrder = new Scanner(System.in).nextInt();
        System.out.println("reorderLevel: ");
        int reorderLevel = new Scanner(System.in).nextInt();
        System.out.println("discontinued: ");
        int discontinued = new Scanner(System.in).nextInt();

        ProductsDTO productsDTO = new ProductsDTO(id, name, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);


        ProductBO bo = new ProductBO(selectDB());

        try {
            bo.update(new ProductsDTO(productsDTO.getPruductId()
                    , productsDTO.getProductName()
                    , productsDTO.getSupplierId()
                    , productsDTO.getCategoryId()
                    , productsDTO.getQuantityPerUnit()
                    , productsDTO.getUnitPrice()
                    , productsDTO.getUnitsInStock()
                    , productsDTO.getUnitsOnOrder()
                    , productsDTO.getReorderLevel()
                    , productsDTO.getDiscontinued()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSuppier() {
        System.out.println("ID: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("Company Name: ");
        String compName = new Scanner(System.in).next();
        System.out.println("Contact Name: ");
        String contaName = new Scanner(System.in).next();
        System.out.println("Contact Title: ");
        String contaTitle = new Scanner(System.in).next();
        System.out.println("Address: ");
        String address = new Scanner(System.in).next();
        System.out.println("City: ");
        String city = new Scanner(System.in).next();
        System.out.println("Region: ");
        String region = new Scanner(System.in).next();
        System.out.println("Postal Code: ");
        String postalCode = new Scanner(System.in).next();
        System.out.println("country: ");
        String country = new Scanner(System.in).next();
        System.out.println("Phone: ");
        String phone = new Scanner(System.in).next();
        System.out.println("Fax: ");
        String fax = new Scanner(System.in).next();
        System.out.println("HomePage: ");
        String homepage = new Scanner(System.in).next();


        Suppliers suppliers = new Suppliers(id, compName, contaName, contaTitle, address, city, region, postalCode, country, phone, fax, homepage);

        SuppliersDTO suppliersDTO =
                new SuppliersDTO(
                        suppliers.getSupplierId()
                        , suppliers.getCompanyName()
                        , suppliers.getContactName()
                        , suppliers.getContactTitle()
                        , suppliers.getAddress()
                        , suppliers.getCity()
                        , suppliers.getRegion()
                        , suppliers.getPostalCode()
                        , suppliers.getCountry()
                        , suppliers.getPhone()
                        , suppliers.getFax()
                        , suppliers.getHomePage());

        SuppliersBO bo = new SuppliersBO(selectDB());

        try {
            bo.update(suppliersDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCategorie() {
        System.out.println("Informe o id");
        int id = new Scanner(System.in).nextInt();
        CategoryBO categoryBO = new CategoryBO(selectDB());
        try {
            categoryBO.getCategorie(id).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showProduct() {
        System.out.println("Informe o id");
        int id = new Scanner(System.in).nextInt();
        ProductBO categoryBO = new ProductBO(selectDB());
        try {
            categoryBO.getProduct(id).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showSupplier() {
        System.out.println("Informe o id");
        int id = new Scanner(System.in).nextInt();
        SuppliersBO categoryBO = new SuppliersBO(selectDB());
        try {
            categoryBO.getSupplier(id).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private int selectDB() {
        System.out.println("****************");
        System.out.println("Informe qual bando de dados deseja usar");
        System.out.println("1. MYSQL");
        System.out.println("2. SQLITE");

        return new Scanner(System.in).nextInt();
    }

}
