$(document).ready(function () {

    $('.collapsible').collapsible();

    var contacts = [];
    var contactFilter = $('#contact_filter');


    getAllContacts();

    function getAllContacts() {
        $.ajax({
            type: 'GET',
            url: getBaseUrl() + '/contacts',
            success: function (data) {
                $(document.body).show();
                $('#nav-mobile').show();
                contacts = data;
                contacts.forEach(function (contact) {
                    generateContactItem(contact);
                })
            },
            error: function (xhr, str) {
                console.log(xhr);
                window.location.href = getBaseUrl() + '/index.html';
            }
        });
    }

    // Function for generating contact list

    function generateContactItem(contact) {
        var phones = getPhoneNumbers(contact);
        var phoneBookList = document.querySelector('.phone-book-list');
        var contactListItem = document.createElement('li');
        contactListItem.className = 'contact';
        contactListItem.id = `contact-item-${contact.id}`;
        contactListItem.innerHTML = `
            <div class="collapsible-header">
                <i class="material-icons">phone</i>
                <span id="contact-${contact.id}-name">[Name]: ${contact.name}  [Address]: ${contact.address}  [Numbers]: ${phones} </span>
            </div>`;
        phoneBookList.appendChild(contactListItem);
        Materialize.updateTextFields();
    }

    function getPhoneNumbers(contact) {
        var phones = "~ ";
        var numbers  = contact.phoneNumbers;
        numbers.forEach(function (number) {
            var singleNumber  ="" + number.phoneNumber +" ~  ";
            phones = phones + singleNumber;
        });
        return phones;
    }

    contactFilter.on('keyup', function (event) {
        filterContacts(event.target.value);
    });

    function filterContacts(value) {
        document.querySelector('.phone-book-list').innerHTML = '';
        var filteredContacts = contacts.filter(function (contact) {
            // Condition for filtering contacts
            var phones = getPhoneNumbers(contact);
            var filterCondition = ~contact.name.indexOf(value) || ~contact.address.indexOf(value) || ~phones.indexOf(value);
            return filterCondition;
        });
        // Re-rendering contact list after filtering
        filteredContacts.forEach(function (contact) {
            generateContactItem(contact);
        })
    }

});

