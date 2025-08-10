#
# Author: Rohtash Lakra
#
from enum import Enum, unique
from typing import Any


@unique
class BaseEnum(Enum):
    """Base Enum for all other Enums. For readability, add constants in Alphabetical order."""

    def __str__(self):
        return f"{self.__class__.__name__} <{self.name}{'=' + str(self.value) if self.value else ''}>"

    def __repr__(self):
        return self.__str__()

    @classmethod
    def names(cls):
        "Returns the list of enum name"
        names = []
        for member in cls:
            if member and member.name:
                names.append(member.name)

        return tuple(names)

    @classmethod
    def of_name(cls, name: str) -> Enum:
        "Returns the Service Request Type object based on request_type param"
        if name is not None:
            for member in cls:
                if member.name.lower() == name.lower():
                    return member

        return None

    @classmethod
    def values(cls):
        "Returns the list of enum values"
        values = []
        for member in cls:
            if member and member.value:
                values.append(member.value)

        return tuple(values)

    @classmethod
    def of_value(cls, value: Any) -> Enum:
        "Returns the Service Request Type object based on request_type param"
        if value is not None:
            for member in cls:
                if member.value == value:
                    return member

        return None

    @classmethod
    def equals(cls, enum_type: Enum, app_env: str) -> bool:
        "Returns true if the text is either equals to name or value of an enum otherwise false"
        if enum_type is None:
            raise ValueError("'enum_type' should provide!")
        if app_env is None:
            raise ValueError("'app_env' should provide!")

        return enum_type == cls.of_name(app_env) or enum_type == cls.of_value(app_env)
